package com.codacy.tools.spotbugs

import com.codacy.tools.scala.seed.DockerEngine

object Engine extends DockerEngine(SpotBugs)()
