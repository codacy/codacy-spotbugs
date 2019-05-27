package com.codacy.tools.spotbugs

import java.nio.file.{Path, Paths}

import better.files.File
import com.codacy.tool.spotbugs.ModuleConfiguration
import com.codacy.tool.spotbugs.helper.PathHelper
import org.scalatest.{Matchers, WordSpecLike}

class PathHelperSpec extends Matchers with WordSpecLike {

  "PathHelper" when {
    "discoverProjectModules" should {

      "identify one module with basic syntax" in {
        val tmp = File.newTemporaryDirectory()
        val classesDir = (tmp / "target" / "classes").createDirectories()
        val sourcesDir = (tmp / "src" / "main").createDirectories()

        PathHelper.discoverProjectModules(tmp.path) should equal(
          Set(ModuleConfiguration(Set(classesDir.pathAsString), Set(sourcesDir.pathAsString)))
        )
      }

      "identify multiple modules with basic syntax" in {
        val tmp = File.newTemporaryDirectory()

        val classesDir1 = (tmp / "1" / "target" / "classes").createDirectories()
        val sourcesDir1 = (tmp / "1" / "src" / "main").createDirectories()
        val classesDir2 = (tmp / "2" / "target" / "classes").createDirectories()
        val sourcesDir2 = (tmp / "2" / "src" / "main").createDirectories()
        val classesDir3 = (tmp / "3" / "target" / "classes").createDirectories()
        val sourcesDir3 = (tmp / "3" / "src" / "main").createDirectories()

        PathHelper.discoverProjectModules(tmp.path) should equal(
          Set(
            ModuleConfiguration(Set(classesDir1.pathAsString), Set(sourcesDir1.pathAsString)),
            ModuleConfiguration(Set(classesDir2.pathAsString), Set(sourcesDir2.pathAsString)),
            ModuleConfiguration(Set(classesDir3.pathAsString), Set(sourcesDir3.pathAsString))
          )
        )
      }

      "identify root as sources and classes in root without class directory" in {
        val tmp = File.newTemporaryDirectory()

        (tmp / "src" / "main").createDirectories()

        PathHelper.discoverProjectModules(tmp.path) should equal(
          Set(ModuleConfiguration(Set(tmp.pathAsString), Set(tmp.pathAsString)))
        )
      }

      "identify root as sources and classes in root without sources directory" in {
        val tmp = File.newTemporaryDirectory()

        (tmp / "target" / "classes").createDirectories()

        PathHelper.discoverProjectModules(tmp.path) should equal(
          Set(ModuleConfiguration(Set(tmp.pathAsString), Set(tmp.pathAsString)))
        )
      }

      "identify all types of sources and classes directories" in {
        val tmp = File.newTemporaryDirectory()

        val classesDir1 = (tmp / "maven" / "target" / "classes").createDirectories()
        val sourcesDir1 = (tmp / "maven" / "src" / "main").createDirectories()
        val classesDir2 = (tmp / "jvm" / "target" / "scala-2.12" / "classes").createDirectories()
        val sourcesDir2 = (tmp / "jvm" / "src" / "main" / "scala").createDirectories()
        val classesDir3 = (tmp / "gradle" / "build" / "classes" / "java" / "main").createDirectories()
        val sourcesDir3 = (tmp / "gradle" / "src" / "main" / "scala").createDirectories()

        PathHelper.discoverProjectModules(tmp.path) should equal(
          Set(
            ModuleConfiguration(Set(classesDir1.pathAsString), Set(sourcesDir1.pathAsString)),
            ModuleConfiguration(
              Set(classesDir2.pathAsString),
              Set(s"${tmp.pathAsString}/jvm/src/main", sourcesDir2.pathAsString)
            ),
            ModuleConfiguration(
              Set(s"${tmp.pathAsString}/gradle/build/classes", classesDir3.pathAsString),
              Set(s"${tmp.pathAsString}/gradle/src/main", sourcesDir3.pathAsString)
            )
          )
        )
      }
    }

    "findModuleRootFromClasses" should {

      "find project root in maven and sbt target syntax" in {
        val rootProjectPath = Paths.get("/home/user/project")
        val classesDir = rootProjectPath.resolve("target/scala-2.12/classes")

        PathHelper.findModuleRootFromClasses(classesDir) should equal(rootProjectPath)
      }

      "find project root in gradle build syntax" in {
        val rootProjectPath = Paths.get("/home/user/project")
        val classesDir = rootProjectPath.resolve("build/classes/java/main")

        PathHelper.findModuleRootFromClasses(classesDir) should equal(rootProjectPath)
      }
    }

    "resolve" should {

      "resolve absolute path" in {
        val tmp = File.newTemporaryDirectory()
        val tmpChild = (tmp / "child").createDirectories()

        PathHelper.resolve(tmp.path, tmpChild.path) should equal(Option(tmpChild.path))
      }

      "resolve relative path" in {
        val tmp = File.newTemporaryDirectory()
        val resolvedPath = (tmp / "child").createDirectories()
        val tmpChild = Paths.get("child")

        PathHelper.resolve(tmp.path, tmpChild) should equal(Option(resolvedPath.path))
      }

      "fail for non existing path" in {
        val tmp = File.newTemporaryDirectory()
        val tmpChild = Paths.get("child")

        PathHelper.resolve(tmp.path, tmpChild) should equal(Option.empty[Path])
      }
    }

    "find" should {

      "find direct child" in {
        val tmp = File.newTemporaryDirectory()
        val tmpChild = (tmp / "child" / "another" / "thing").createDirectories()

        PathHelper.find(Set(tmpChild.path), "child/another/thing") should equal(Option(tmpChild.path))
      }

      "find non-direct child" in {
        val tmp = File.newTemporaryDirectory()
        val tmpChild = (tmp / "child" / "another" / "thing").createDirectories()

        PathHelper.find(Set(tmpChild.path), "another/thing") should equal(Option(tmpChild.path))
      }

      "not find file for suffix when no roots are passed" in {
        val tmp = File.newTemporaryDirectory()
        (tmp / "child" / "another" / "thing").createDirectories()

        PathHelper.find(Set.empty[Path], "another/thing") should equal(Option.empty[Path])
      }

      "not find file for suffix when suffix does not exist" in {
        val tmp = File.newTemporaryDirectory()
        val tmpChild = (tmp / "child" / "another" / "thing").createDirectories()

        PathHelper.find(Set(tmpChild.path), "child/another/thinsg") should equal(Option.empty[Path])
      }
    }
  }
}
