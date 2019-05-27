package com.codacy.tool.spotbugs.helper

import better.files.File
import com.codacy.tool.spotbugs.Keys
import edu.umd.cs.findbugs.{DetectorFactoryCollection, Plugin}

case class PluginDefinition(pluginId: String, pluginOrg: String, pluginName: String, pluginVersion: String) {

  val locations: List[File] = List(
    File(Keys.defaultLinuxInstallLocation) / s"lib/$pluginOrg.$pluginName-$pluginVersion.jar",
    Keys.dependenciesLocation
      .fold(File.home / ".ivy2")(File(_)) / s"cache/$pluginOrg/$pluginName/jars/$pluginName-$pluginVersion.jar"
  )
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

}
