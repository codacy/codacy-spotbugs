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
            getSubCategory(pattern),
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

  // order affects results since some BugPatterns match more than one item
  private val matchingPatterns = List(
    "XSS" -> Pattern.Subcategory.XSS,
    "ANDROID" -> Pattern.Subcategory.Android,
    "COOKIE" -> Pattern.Subcategory.Cookies,
    "HTTP" -> Pattern.Subcategory.HTTP,
    "SERVLET" -> Pattern.Subcategory.InputValidation,
    "PATH_TRAVERSAL" -> Pattern.Subcategory.FileAccess,
    "SQL_INJECTION" -> Pattern.Subcategory.SQLInjection,
    "INJECTION" -> Pattern.Subcategory.CommandInjection,
    "JAX" -> Pattern.Subcategory.HTTP,
    "XXE" -> Pattern.Subcategory.InputValidation,
    "CSRF" -> Pattern.Subcategory.CSRF,
    "JSP" -> Pattern.Subcategory.InputValidation,
    "UNVALIDATED" -> Pattern.Subcategory.InputValidation,
    "ENDPOINT" -> Pattern.Subcategory.InputValidation,
    "DIGEST" -> Pattern.Subcategory.Cryptography,
    "WEAK" -> Pattern.Subcategory.InputValidation,
    "CIPHER" -> Pattern.Subcategory.Cryptography,
    "ENCRYPT" -> Pattern.Subcategory.Cryptography,
    "RSA" -> Pattern.Subcategory.Cryptography,
    "DESERIALIZATION" -> Pattern.Subcategory.CommandInjection,
    "DES" -> Pattern.Subcategory.Cryptography,
    "FILE" -> Pattern.Subcategory.FileAccess,
    "PREDICTABLE_RANDOM" -> Pattern.Subcategory.Cryptography,
    "ENTITY" -> Pattern.Subcategory.Visibility
  )

  private def getSubCategory(bugPattern: BugPattern): Option[Pattern.Subcategory] =
    if (getCategory(bugPattern.getCategory) != Pattern.Category.Security)
      None
    else
      bugPattern.getAbbrev match {
        case "SQL" => Some(Pattern.Subcategory.SQLInjection)
        case "Dm" => Some(Pattern.Subcategory.Auth)
        case "PT" => Some(Pattern.Subcategory.FileAccess)
        case "HRS" => Some(Pattern.Subcategory.HTTP)
        case "XSS" => Some(Pattern.Subcategory.XSS)
        case "SECJSPJSTL" => Some(Pattern.Subcategory.XSS) // JSP_JSTL_OUT
        case "SECJSPINC" => Some(Pattern.Subcategory.XSS) // JSP_INCLUDE !!!!!
        case "SECWTM" => Some(Pattern.Subcategory.SSL) // WEAK_TRUST_MANAGER !!!!!
        case "SECSC" => Some(Pattern.Subcategory.Other) // SPRING_ENDPOINT
        case "SECXPI" => Some(Pattern.Subcategory.InputValidation) // XPATH_INJECTION
        case "SECCUSTOMI" => Some(Pattern.Subcategory.SQLInjection) // CUSTOM_INJECTION
        case "SECLDAPI" => Some(Pattern.Subcategory.InputValidation) // LDAP_INJECTION
        case "SECCRLFLOG" => Some(Pattern.Subcategory.InputValidation) // CRLF_INJECTION_LOGS
        case "SECAQI" => Some(Pattern.Subcategory.SQLInjection) // AWS_QUERY_INJECTION
        case "SECSMTP" => Some(Pattern.Subcategory.HTTP) // SMTP_HEADER_INJECTION
        case "SECRD" => Some(Pattern.Subcategory.Regex) // REDOS
        case "SECHCP" => Some(Pattern.Subcategory.Auth) // HARD_CODE_PASSWORD
        case "SECHCK" => Some(Pattern.Subcategory.Cryptography) // HARD_CODE_KEY
        case "SECBKS" => Some(Pattern.Subcategory.Cryptography) // BLOWFISH_KEY_SIZE
        case "SECHPP" => Some(Pattern.Subcategory.InputValidation) // HTTP_PARAMETER_POLLUTION
        case "SECSSSRF" => Some(Pattern.Subcategory.InputValidation) // SCALA_PLAY_SSRF
        case "SECSSSRFUC" => Some(Pattern.Subcategory.FileAccess) // URLCONNECTION_SSRF_FD
        case "SECECB" => Some(Pattern.Subcategory.Cryptography) // ECB_MODE
        case "STAIV" => Some(Pattern.Subcategory.Cryptography) // STATIC_IV
        case "SECFSM" => Some(Pattern.Subcategory.InputValidation) // FORMAT_STRING_MANIPULATION
        case "SECISC" => Some(Pattern.Subcategory.SSL) // INSECURE_SMTP_SSL
        case "SECURLR" => Some(Pattern.Subcategory.HTTP) // URL_REWRITING
        case "SECCORS" => Some(Pattern.Subcategory.HTTP) // PERMISSIVE_CORS
        case "SECSSL" => Some(Pattern.Subcategory.SSL) // SSL_CONTEXT
        case "SECSAMLC" => Some(Pattern.Subcategory.Auth) // SAML_IGNORE_COMMENTS
        case "LDAPA" => Some(Pattern.Subcategory.Auth) // LDAP_ANONYMOUS
        case "SECLDAPEP" => Some(Pattern.Subcategory.CommandInjection) // LDAP_ENTRY_POISONING
        case "SECBHC" => Some(Pattern.Subcategory.Cryptography) // BAD_HEXA_CONVERSION
        case "SECUHE" => Some(Pattern.Subcategory.Other) // UNSAFE_HASH_EQUALS
        case "SECSFV" => Some(Pattern.Subcategory.InputValidation) // STRUTS_FORM_VALIDATION
        case "SECXSLT" => Some(Pattern.Subcategory.InputValidation) // MALICIOUS_XSLT
        case "XMLDEC" => Some(Pattern.Subcategory.InputValidation) // XML_DECODER
        case "PADORA" => Some(Pattern.Subcategory.Cryptography) // PADDING_ORACLE
        case "SECCONFCTRL" => Some(Pattern.Subcategory.InputValidation) // EXTERNAL_CONFIG_CONTROL
        case "SECTBV" => Some(Pattern.Subcategory.InputValidation) // TRUST_BOUNDARY_VIOLATION
        case "SECSDL" => Some(Pattern.Subcategory.Visibility) // SCALA_SENSITIVE_DATA_EXPOSURE
        case "ERRMSG" => Some(Pattern.Subcategory.Visibility) // INFORMATION_EXPOSURE_THROUGH_AN_ERROR_MESSAGE
        case "RPCEXT" => Some(Pattern.Subcategory.CommandInjection) // RPC_ENABLED_EXTENSIONS
        case _ =>
          matchingPatterns.collectFirst {
            case (pattern, subcategory) if bugPattern.getType.contains(pattern) => subcategory
          }
      }
}
