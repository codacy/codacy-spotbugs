package com.codacy.tools.spotbugs

import java.nio.file.Paths

import org.scalatest.{Matchers, WordSpecLike}

class SpotBugsSpec extends Matchers with WordSpecLike {

  "SpotBugs" when {
    "detecting languages" should {

      "detect scala on a set of only scala files" in {
        val files = Option(
          Set(
            Paths.get("bla/bla/bleeeee/Carlos.scala"),
            Paths.get("/blaaaa/ble/Carlos2.scala"),
            Paths.get("path/to/file/Carlos1000.scala")
          )
        )

        SpotBugs.isScala(files) shouldBe true
      }

      "not detect scala on a set of non-scala files" in {
        val files = Option(
          Set(
            Paths.get("bla/bla/bleeeee/Carlos.java"),
            Paths.get("/blaaaa/ble/Carlos2.py"),
            Paths.get("path/to/file/Carlos1000.notalanguage")
          )
        )

        SpotBugs.isScala(files) shouldBe false
      }

      "not detect scala on a set with a mix of scala and non-scala files" in {
        val files = Option(
          Set(
            Paths.get("bla/bla/bleeeee/Carlos.scala"),
            Paths.get("/blaaaa/ble/Carlos2.py"),
            Paths.get("path/to/file/Carlos1000.notalanguage")
          )
        )

        SpotBugs.isScala(files) shouldBe false
      }
    }
  }
}
