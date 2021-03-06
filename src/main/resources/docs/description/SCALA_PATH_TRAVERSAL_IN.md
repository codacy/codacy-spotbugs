# [Potential Path Traversal using Scala API (file read)](https://find-sec-bugs.github.io/bugs.htm#SCALA_PATH_TRAVERSAL_IN)

A file is opened to read its content. The filename comes from an **input** parameter.
If an unfiltered parameter is passed to this file API, files from an arbitrary filesystem location could be read.

This rule identifies **potential** path traversal vulnerabilities. In many cases, the constructed file path cannot be controlled
by the user. If that is the case, the reported instance is a false positive.

    **Vulnerable Code:**  

<pre>def getWordList(value:String) = Action {
  if (!Files.exists(Paths.get("public/lists/" + value))) {
    NotFound("File not found")
  } else {
    val result = Source.fromFile("public/lists/" + value).getLines().mkString // Weak point
    Ok(result)
  }
}</pre>

    **Solution:**  

<pre>import org.apache.commons.io.FilenameUtils;

def getWordList(value:String) = Action {
  val filename = "public/lists/" + FilenameUtils.getName(value)

  if (!Files.exists(Paths.get(filename))) {
    NotFound("File not found")
  } else {
    val result = Source.fromFile(filename).getLines().mkString // Fix
    Ok(result)
  }
}</pre>

**References**  

[WASC: Path Traversal](http://projects.webappsec.org/w/page/13246952/Path%20Traversal)  

[OWASP: Path Traversal](https://www.owasp.org/index.php/Path_Traversal)  

[CAPEC-126: Path Traversal](https://capec.mitre.org/data/definitions/126.html)  

[CWE-22: Improper Limitation of a Pathname to a Restricted Directory ('Path Traversal')](https://cwe.mitre.org/data/definitions/22.html)