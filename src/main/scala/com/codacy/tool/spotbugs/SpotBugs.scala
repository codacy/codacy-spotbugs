package com.codacy.tool.spotbugs

import java.io._
import java.nio.file._

import com.codacy.plugins.api.results.{Pattern, Result, Tool}
import com.codacy.plugins.api.{Options, Source, _}
import com.codacy.tool.spotbugs.helper.{PathHelper, SpotBugsHelper}
import com.codacy.tools.scala.seed.utils.FileHelper
import com.codacy.tools.scala.seed.utils.ToolHelper._
import edu.umd.cs.findbugs
import edu.umd.cs.findbugs._

import scala.collection.JavaConverters._
import scala.util.{Failure, Success, Try}

object SpotBugs extends Tool {

  private val includesFilenames = Set("findbugs.xml", "findbugs-includes.xml", "spotbugs.xml", "spotbugs-includes.xml")
  private val excludesFilenames = Set("findbugs-excludes.xml", "spotbugs-excludes.xml")

  override def apply(
      source: Source.Directory,
      configuration: Option[List[Pattern.Definition]],
      files: Option[Set[Source.File]],
      options: Map[Options.Key, Options.Value]
  )(implicit specification: Tool.Specification): Try[List[Result]] = Try {
    val sourcePath = Paths.get(source.path)
    val filesPath = files.map(_.map(s => Paths.get(s.path)))

    val (includesFile, excludesFile) = configuration.withDefaultParameters
      .map(generateIncludeXMLFile)
      .map { rules =>
        (Option(rules.toAbsolutePath), Option.empty[Path])
      }
      .getOrElse {
        (
          FileHelper.findConfigurationFile(sourcePath, includesFilenames),
          FileHelper.findConfigurationFile(sourcePath, excludesFilenames)
        )
      }

    val modulesConfiguration = options
      .get(Options.Key("modules"))
      .map(optionsValueToJsValue)
      .map(_.as[Set[ModuleConfiguration]])
      .getOrElse(PathHelper.discoverProjectModules(sourcePath))

    SpotBugsHelper.loadPlugins(SpotBugsHelper.defaultPlugins)

    val results: List[Try[List[Result]]] = modulesConfiguration.map { moduleConfiguration =>
      runTool(sourcePath, filesPath, moduleConfiguration, includesFile, excludesFile)
    }(collection.breakOut)

    /* Skip modules if classes where not found but fail if other error occurs
     * e.g.: Some modules can contain only resources and not have any actual compiled code to analyse
     */
    results.flatMap {
      case Success(res) => res
      case Failure(e: IOException) if e.getMessage == "No files to analyze could be opened" => List.empty[Result]
      case Failure(e) =>
        throw e
    }
  }

  private def runTool(
      root: Path,
      files: Option[Set[Path]],
      moduleConfiguration: ModuleConfiguration,
      includesFile: Option[Path],
      excludesFile: Option[Path]
  ): Try[List[Result]] = Try {
    val detector = DetectorFactoryCollection.instance()
    val projectStats = new ProjectStatsWithoutCustomProfiler()
    val project = new Project()
    val userPreferences = project.getConfiguration

    project.addWorkingDir(root.toString)
    moduleConfiguration.classesDirectories
      .flatMap(
        dir =>
          PathHelper
            .resolve(root, Paths.get(dir))
      )
      .foreach(cd => project.addFile(cd.toString))

    // TODO: check if we can we get the jars to pass here
    // project.addAuxClasspathEntry(???)

    includesFile.map(path => project.getConfiguration.getIncludeFilterFiles.put(path.toString, true))
    excludesFile.map(path => project.getConfiguration.getExcludeFilterFiles.put(path.toString, true))

    val bugReporter = {
      // TODO: check this workaround for Scala code
      // val inMemoryBugReporter = new InMemoryBugReporter(project, projectStats)
      // new CategoryFilteringBugReporter(inMemoryBugReporter, Set("SECURITY").asJava)
      new InMemoryBugReporter(project, projectStats)
    }
    bugReporter.setPriorityThreshold(Priorities.NORMAL_PRIORITY)

    val findBugs = new FindBugs2()
    findBugs.setProject(project)
    findBugs.setBugReporter(bugReporter)
    findBugs.setDetectorFactoryCollection(detector)
    findBugs.setUserPreferences(userPreferences)

    SpotBugsHelper.defaultPlugins.foreach(plugin => project.setPluginStatusTrinary(plugin.pluginId, true))

    findBugs.execute()
    findBugs.close()

    val bugReports = bugReporter.getBugCollection.getCollection.asScala.to[Set]
    convertBugsToResults(root, bugReports, files, moduleConfiguration)
  }

  private def isFileEnabled(path: String, filesOpt: Option[Set[Path]]): Boolean = {
    filesOpt.fold(true) { files =>
      files.exists(_.toString == path)
    }
  }

  private def convertBugsToResults(
      root: Path,
      bugs: Set[findbugs.BugInstance],
      files: Option[Set[Path]],
      moduleConfiguration: ModuleConfiguration
  ): List[Result] = {
    val sourceDirectories = moduleConfiguration.sourceDirectories
      .flatMap(
        dir =>
          PathHelper
            .resolve(root, Paths.get(dir))
      )
    (for {
      (shortPath, bugs) <- bugs.groupBy(_.getPrimarySourceLineAnnotation.getSourcePath)
      filePath <- PathHelper.find(sourceDirectories, shortPath).to[List]
      if isFileEnabled(filePath.toString, files)
      bug <- bugs if bug.getPrimarySourceLineAnnotation.getStartLine > 0
    } yield {
      Result.Issue(
        Source.File(filePath.toString),
        Result.Message(bug.getMessageWithoutPrefix),
        Pattern.Id(bug.getType),
        Source.Line(bug.getPrimarySourceLineAnnotation.getStartLine)
      )
    })(collection.breakOut)
  }

  private def generateIncludeXMLFile(conf: List[Pattern.Definition]): Path = {
    val xmlLiteral = <FindBugsFilter>
      {conf.map(pattern =>
        <Match>
          <Bug pattern={pattern.patternId.value}/>
        </Match>
      )}
    </FindBugsFilter>

    FileHelper.createTmpFile(xmlLiteral.toString, Keys.toolName, "")
  }

}
