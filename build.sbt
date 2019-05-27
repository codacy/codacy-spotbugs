import com.typesafe.sbt.packager.docker.Cmd

name := "codacy-spotbugs"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.8"

resolvers += Resolver.sonatypeRepo("public")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.2.0",
  "com.codacy" %% "codacy-engine-scala-seed" % "3.0.296",
  "com.github.spotbugs" % "spotbugs" % better.files.File(".spotbugs-version").lines().head.trim,
  "com.h3xstream.findsecbugs" % "findsecbugs-plugin" % better.files.File(".findsecbugs-version").lines().head.trim,
  "com.mebigfatguy.sb-contrib" % "sb-contrib" % better.files.File(".sb-contrib-version").lines().head.trim,
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0",
  "com.github.tkqubo" % "html-to-markdown" % "0.7.2"
).map(_.withSources())

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.7" % "test"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)

version in Docker := "1.0.0-SNAPSHOT"

sourceGenerators.in(Compile) += Def.task {

  def getVersion(name: String): String = {
    IO.readLines(new java.io.File(s".$name-version")).headOption.map(_.trim).getOrElse {
      throw new Exception(s"Failed to retrieve version .$name-version")
    }
  }

  val file = sourceManaged.in(Compile).value / "com" / "codacy" / "tool" / "spotbugs" / "Keys.scala"
  IO.write(
    file,
    s"""|package com.codacy.tool.spotbugs
       |
       |object Keys {
       |
       |  val toolName: String = "spotbugs"
       |
       |  val spotBugsVersion: String = "${getVersion("spotbugs")}"
       |  val findsecbugsVersion: String = "${getVersion("findsecbugs")}"
       |  val sbContribVersion: String = "${getVersion("sb-contrib")}"
       |
       |  val defaultLinuxInstallLocation: String = "${defaultLinuxInstallLocation.in(Docker).value}"
       |  val dependenciesLocation: Option[String] = ${ivyPaths
         .in(Compile)
         .value
         .ivyHome
         .fold("Option.empty[String]")(home => s"""Option("$home")""")}
       |
       |}""".stripMargin
  )
  Seq(file)
}.taskValue

mappings.in(Universal) ++= resourceDirectory
  .in(Compile)
  .map { resourceDir: File =>
    val src = resourceDir / "docs"
    val dest = "/docs"

    (for {
      path <- better.files.File(src.toPath).listRecursively()
      if !path.isDirectory
    } yield path.toJava -> path.toString.replaceFirst(src.toString, dest)).toSeq
  }
  .value

val dockerUser = "docker"
val dockerUserId = "2004"

daemonUser in Docker := dockerUser
daemonUserUid in Docker := Option(dockerUserId)
daemonGroup in Docker := dockerUser
daemonGroupGid in Docker := Option(dockerUserId)

dockerBaseImage := "frolvlad/alpine-java:jre8-slim"

mainClass := Some("com.codacy.tool.spotbugs.Engine")

// DEPRECATED: Start using the Dockerfile
dockerCommands := dockerCommands.value.flatMap {
  case cmd @ Cmd("WORKDIR", "/opt/docker") =>
    List(cmd, Cmd("RUN", s"adduser", "-u", dockerUserId, "-D", dockerUser))
  case cmd @ Cmd("USER", "docker") =>
    List(Cmd("RUN", s"mv", "/opt/docker/docs", "/docs"), cmd)
  case other => List(other)
}
