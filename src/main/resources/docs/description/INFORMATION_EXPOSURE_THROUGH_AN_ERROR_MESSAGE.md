# [Information Exposure Through An Error Message](http://find-sec-bugs.github.io/bugs.htm#INFORMATION_EXPOSURE_THROUGH_AN_ERROR_MESSAGE)

The sensitive information may be valuable information on its own (such as a password), or it may be useful for launching other, more deadly attacks. If an attack fails, an attacker may use error information provided by the server to launch another more focused attack. For example, an attempt to exploit a path traversal weakness (CWE-22) might yield the full pathname of the installed application. In turn, this could be used to select the proper number of ".." sequences to navigate to the targeted file. An attack using SQL injection (CWE-89) might not initially succeed, but an error message could reveal the malformed query, which would expose query logic and possibly even passwords or other sensitive information used within the query.

    **Vulnerable Code:**  

<pre>try {
  out = httpResponse.getOutputStream()
} catch (Exception e) {
  e.printStackTrace(out);
}</pre>

**References**  

[CWE-209: Information Exposure Through an Error Message](https://cwe.mitre.org/data/definitions/209.html)