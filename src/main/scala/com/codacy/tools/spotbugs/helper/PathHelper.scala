package com.codacy.tools.spotbugs.helper

import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.{Files, _}

import com.codacy.tools.spotbugs.ModuleConfiguration

import scala.annotation.tailrec
import scala.collection.JavaConverters._
import scala.compat.java8.OptionConverters._

object PathHelper {

  /*
   * Tries to discover the modules inside `root`.
   * Starts by searching patterns looking like the path where the build systems place the compiled classes,
   * and then for each location creates a module with the sources bases on this location.
   *
   *
   * # Examples of locations
   *
   * ## Sources
   *
   *  - src/main (Maven)
   *  - src/test (Maven)
   *  - src/main/scala (SBT, Gradle)
   *  - src/main/java (SBT, Gradle)
   *  - src/test/java (SBT, Gradle)
   *  - js/src/main/scala (SBT) [not relevant since it is treated as a module of its own called js]
   *  - jvm/src/main/scala (SBT) [not relevant since it is treated as a module of its own called jvm]
   *  - shared/src/main/scala (SBT) [not relevant since it is treated as a module of its own called shared]
   *
   *  ## Compiled Classes
   *
   *  - target/classes (Maven)
   *  - target/test-classes (Maven)
   *  - target/scala-2.10/classes (SBT)
   *  - target/scala-2.11/classes (SBT)
   *  - target/scala-2.12/classes (SBT)
   *  - target/scala-2.13/classes (SBT)
   *  - target/scala-2.11/test-classes (SBT)
   *  - build/classes/java/main (Gradle)
   *  - build/classes/java/test (Gradle)
   *
   *
   *  ## Caveats
   *
   *  In certain cases we might have a sub-optimal discovery.
   *  This leads to duplicated paths. Should not be a problem but can lead to some inefficiencies.
   *  e.g.:
   *    - `build/classes/java/main` is also detected as `build/classes`
   *    - `src/main/scala` is also detected as `src/main`
   */
  def discoverProjectModules(root: Path): Set[ModuleConfiguration] = {
    val classesMatcher =
      FileSystems.getDefault.getPathMatcher("glob:**{target,build}/{*classes,*/*classes,classes/*/main,classes/*/test}")
    val sourcesMatcher = FileSystems.getDefault.getPathMatcher("glob:**src/{main,main/*,test,test/*}")

    val modules = Files
      .find(
        root,
        Int.MaxValue,
        (t: Path, _: BasicFileAttributes) => classesMatcher.matches(t),
        FileVisitOption.FOLLOW_LINKS
      )
      .iterator()
      .asScala
      .to[Set]
      .map(classesDirectory => (findModuleRootFromClasses(classesDirectory), classesDirectory))
      .groupBy { case (moduleRoot, _) => moduleRoot }
      .map {
        case (moduleRoot, classesAndRootTuple) =>
          (moduleRoot, classesAndRootTuple.map { case (_, classesDirectory) => classesDirectory })
      }
      .flatMap {
        case (moduleRoot, classesDirectories) =>
          val sourcesRoot: Set[Path] = Files
            .find(
              moduleRoot,
              Int.MaxValue,
              (t: Path, _: BasicFileAttributes) => sourcesMatcher.matches(t),
              FileVisitOption.FOLLOW_LINKS
            )
            .iterator()
            .asScala
            .to[Set]

          // Remove modules where the sources directory could not be detected
          Option(sourcesRoot)
            .filter(_.nonEmpty)
            .map(srcs => ModuleConfiguration(classesDirectories.map(_.toString), srcs.map(_.toString)))
      }
      .to[Set]

    if (modules.nonEmpty) {
      modules
    } else {
      /* Let's consider the root a big project
       * This is not a good behaviour:
       *  e.g.: If a two modules have files with same paths relative to their root,
       *        we don't have a way to match the issues correctly to the files.
       */
      Set(ModuleConfiguration(Set(root.toString), Set(root.toString)))
    }
  }

  @tailrec
  def findModuleRootFromClasses(path: Path): Path = {
    if (// Maven and SBT root for compilation
      path.getFileName.toString == "target" ||
      // Gradle root for compilation
      path.getFileName.toString == "build") {
      path.getParent
    } else {
      findModuleRootFromClasses(path.getParent)
    }
  }

  // Tries to resolve the strings in `paths` if they are absolute, or relative to `root`
  def resolve(root: Path, path: Path): Option[Path] = {
    Option(path).collect {
      case pth if Files.exists(pth) => pth
      case pth if !pth.isAbsolute && Files.exists(root.resolve(pth)) => root.resolve(pth)
    }
  }

  /* Finds the first path inside any root in `roots` that ends with `suffix`:
   *  1. Search each root for a direct resolution
   *  2. Search each root recursively for the first matching suffix
   */
  def find(roots: Set[Path], suffix: String): Option[Path] = {
    roots.toStream
      .flatMap(resolve(_, Paths.get(suffix)))
      .headOption
      .orElse(findRecursively(roots, suffix))
  }

  @tailrec
  def findRecursively(roots: Set[Path], suffix: String): Option[Path] = {
    roots.headOption match {
      case None => None

      case Some(root) =>
        val matchingPath = Files
          .find(
            root,
            Int.MaxValue,
            (t: Path, _: BasicFileAttributes) => t.endsWith(suffix),
            FileVisitOption.FOLLOW_LINKS
          )
          .findFirst()
          .asScala

        matchingPath match {
          case path @ Some(_) => path
          case None => findRecursively(roots.drop(1), suffix)
        }
    }
  }

}
