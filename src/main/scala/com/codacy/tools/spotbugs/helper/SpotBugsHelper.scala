package com.codacy.tools.spotbugs.helper

import better.files.File
import com.codacy.tools.spotbugs.{InMemoryBugReporter, Keys, ProjectStatsWithoutCustomProfiler}
import edu.umd.cs.findbugs._

import scala.collection.JavaConverters._

case class PluginDefinition(pluginId: String, pluginOrg: String, pluginName: String, pluginVersion: String) {
  private val cacheDirectory = File(Keys.dependenciesLocation)
  // look for the plugins in the machines local cache (coursier) downloaded during Compile
  private val cacheFiles =
    if (cacheDirectory.exists && cacheDirectory.isDirectory)
      File(Keys.dependenciesLocation).collectChildren(_.name == s"$pluginName-$pluginVersion.jar", 20)
    else Iterator.empty

  val locations: List[File] = List(
    File(Keys.defaultLinuxInstallLocation) / s"lib/$pluginOrg.$pluginName-$pluginVersion.jar",
  ) ++ cacheFiles
}

object SpotBugsHelper {

  val defaultPlugins: Set[PluginDefinition] = Set(
    PluginDefinition(
      "com.h3xstream.findsecbugs",
      "com.h3xstream.findsecbugs",
      "findsecbugs-plugin",
      Keys.findsecbugsVersion
    ),
    PluginDefinition("com.mebigfatguy.fbcontrib", "com.mebigfatguy.sb-contrib", "sb-contrib", Keys.sbContribVersion)
  )

  def loadPlugins(plugins: Set[PluginDefinition]): Set[Plugin] = {
    plugins.map { plugin =>
      plugin.locations
        .find(_.exists)
        .fold {
          throw new Exception(s"Could not find ${plugin.pluginName} jar!")
        } { location =>
          Plugin.loadCustomPlugin(location.toJava, null)
          val pluginInstance = DetectorFactoryCollection.instance.getPluginById(plugin.pluginId)
          pluginInstance.setGloballyEnabled(true)
          pluginInstance
        }
    } + DetectorFactoryCollection.instance.getCorePlugin
  }

  def createBugReporter(
      project: Project,
      projectStats: ProjectStatsWithoutCustomProfiler,
      isScala: Boolean
  ): BugReporter = {

    // If the language is Scala, we only want to use patterns from FindSecBugs since SpotBugs and other plugins
    // do not support the language. The best way to perform this since we cannot disable the main SpotBugs plugin
    // is to filter security patterns to avoid false positives
    val bugReporter = if (isScala) {
      val inMemoryBugReporter = new InMemoryBugReporter(project, projectStats)
      new CategoryFilteringBugReporter(inMemoryBugReporter, Set("SECURITY").asJava)
    } else {
      new InMemoryBugReporter(project, projectStats)
    }
    bugReporter.setPriorityThreshold(Priorities.NORMAL_PRIORITY)
    bugReporter
  }

}
