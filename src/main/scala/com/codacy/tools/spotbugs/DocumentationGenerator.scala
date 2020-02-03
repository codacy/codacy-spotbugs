package com.codacy.tools.spotbugs

import com.codacy.plugins.api.results.{Pattern, Result, Tool}
import com.codacy.tools.spotbugs.helper.SpotBugsHelper
import com.github.tkqubo.html2md.Html2Markdown
import edu.umd.cs.findbugs._
import play.api.libs.json.Json

import scala.collection.JavaConverters._
import scala.collection.immutable.ListSet

object DocumentationGenerator {

  def main(args: Array[String]): Unit = {
    val allPatterns: List[BugPattern] =
      SpotBugsHelper.loadPlugins(SpotBugsHelper.defaultPlugins).flatMap(_.getBugPatterns.asScala)(collection.breakOut)
    writePatterns(allPatterns)

  }

  private def writePatterns(allPatterns: List[BugPattern]): Unit = {
    val specifications = ListSet(
      allPatterns
        .map { pattern =>
          Pattern.Specification(
            Pattern.Id(pattern.getType),
            getLevel(pattern.getCategory),
            getCategory(pattern.getCategory),
            None,
            None
          )
        }
        .sortBy(_.patternId.value)(Ordering[String].reverse): _*
    )

    val descriptions = allPatterns
      .map { pattern =>
        Pattern.Description(
          Pattern.Id(pattern.getType),
          Pattern.Title(pattern.getShortDescription),
          Option(Pattern.DescriptionText(pattern.getLongDescription)),
          None,
          None
        )
      }
      .sortBy(_.patternId.value)

    val spec = Tool.Specification(Tool.Name(Keys.toolName), Some(Tool.Version(Keys.spotBugsVersion)), specifications)

    val jsonSpecifications = Json.prettyPrint(Json.toJson(spec))
    val jsonDescriptions = Json.prettyPrint(Json.toJson(descriptions))

    val repoRoot = better.files.File(".")
    val docsRoot = repoRoot / "src/main/resources/docs"
    val patternsFile = docsRoot / "patterns.json"
    val descriptionsRoot = docsRoot / "description"
    val descriptionsFile = descriptionsRoot / "description.json"

    descriptionsRoot.createDirectories()
    patternsFile.write(jsonSpecifications)
    descriptionsFile.write(jsonDescriptions)
    allPatterns.foreach { pattern =>
      val descriptionsFile = descriptionsRoot / s"${pattern.getType}.md"
      val markdown = Html2Markdown.toMarkdown(pattern.getDetailHTML)
      descriptionsFile.write(markdown)
    }
  }

  private def getCategory(category: String): Pattern.Category = {
    category match {
      case "BAD_PRACTICE" => Pattern.Category.BestPractice
      case "MALICIOUS_CODE" => Pattern.Category.Security
      case "CORRECTNESS" => Pattern.Category.ErrorProne
      case "PERFORMANCE" => Pattern.Category.Performance
      case "SECURITY" => Pattern.Category.Security
      case "STYLE" => Pattern.Category.CodeStyle
      case "EXPERIMENTAL" => Pattern.Category.ErrorProne
      case "MT_CORRECTNESS" => Pattern.Category.ErrorProne
      case "I18N" => Pattern.Category.BestPractice
      case _ => Pattern.Category.CodeStyle
    }
  }

  private def getLevel(category: String): Result.Level = {
    category match {
      case "BAD_PRACTICE" => Result.Level.Warn
      case "MALICIOUS_CODE" => Result.Level.Err
      case "CORRECTNESS" => Result.Level.Warn
      case "PERFORMANCE" => Result.Level.Warn
      case "SECURITY" => Result.Level.Err
      case "STYLE" => Result.Level.Info
      case "EXPERIMENTAL" => Result.Level.Info
      case "MT_CORRECTNESS" => Result.Level.Warn
      case "I18N" => Result.Level.Info
      case _ => Result.Level.Info
    }
  }

}
