package com.codacy.tools.spotbugs

import java.io.IOException
import java.nio.file._

import com.codacy.plugins.api.results.{Pattern, Result, Tool}
import com.codacy.plugins.api.{Options, Source, _}
import com.codacy.tools.spotbugs.helper.{PathHelper, SpotBugsHelper}
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
  )(implicit specification: Tool.Specification): Try[List[Result]] = {
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

    val modulesResults: List[Option[List[Result]]] = modulesConfiguration.map { moduleConfiguration =>
      runTool(sourcePath, filesPath, moduleConfiguration, includesFile, excludesFile)
    }(collection.breakOut)

    if (modulesResults.exists(_.isDefined)) {
      val flatResults: List[Result] = modulesResults.flatMap {
        case Some(res) => res
        case _ => List.empty[Result]
      }(collection.breakOut)
      Success(flatResults)
    } else {
      val prettyPrintModules =
        modulesConfiguration
          .map(mc => s"""|- classesDirectories: ${mc.classesDirectories.mkString(", ")}
                         |  sourceDirectories: ${mc.sourceDirectories.mkString(", ")}""".stripMargin)
          .mkString("\n\n")

      Failure(new Exception(s"""|Could not find compiled code inside modules:
                                |
                                |$prettyPrintModules
                                |""".stripMargin))
    }
  }

  private def runTool(
      root: Path,
      files: Option[Set[Path]],
      moduleConfiguration: ModuleConfiguration,
      includesFile: Option[Path],
      excludesFile: Option[Path]
  ): Option[List[Result]] = {
    Try {
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

      val bugReporter = SpotBugsHelper.createBugReporter(project, projectStats, isScala(files))

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
    } match {
      case Success(res) => Option(res)

      /* Skip modules if classes where not found but fail if other error occurs
       * e.g.: Some modules can contain only resources and not have any actual compiled code to analyse
       */
      case Failure(ex: IOException) if ex.getMessage == "No files to analyze could be opened" =>
        Option.empty[List[Result]]

      case Failure(ex: Exception) => throw ex
    }
  }

  private[spotbugs] def isScala(filesOpt: Option[Set[Path]]): Boolean = {
    val scalaExtensionMatcher = FileSystems.getDefault().getPathMatcher("glob:**.scala")
    filesOpt.map(_.forall(scalaExtensionMatcher.matches)).getOrElse(false)
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
