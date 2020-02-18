# [XSSRequestWrapper is a weak XSS protection](https://find-sec-bugs.github.io/bugs.htm#XSS_REQUEST_WRAPPER)

An implementation of `HttpServletRequestWrapper` called `XSSRequestWrapper` was published through
various blog sites. <sup>[[1]](https://java.dzone.com/articles/stronger-anti-cross-site)</sup>
<sup>[[2]](https://www.javacodegeeks.com/2012/07/anti-cross-site-scripting-xss-filter.html)</sup>

The filtering is weak for a few reasons:

*   It covers only parameters not headers and side-channel inputs
*   The chain of replace functions can be bypassed easily (see example below)
*   It's a black list of very specific bad patterns (rather than a white list of good/valid input)

**Example of bypass:**  

<pre>
 <scrivbscript:pt>
  alert(1)
 </scrivbscript:pt></pre>

The previous input will be transformed into **`"<script>alert(1)</script>"`**.
The removal of `"vbscript:"` is after the replacement of `"<script>.*</script>"`.

For stronger protection, choose a solution that encodes characters automatically in the **<u>view</u>** (template or JSP) following
the XSS protection rules defined in the OWASP XSS Prevention Cheat Sheet.

**References**  

[WASC-8: Cross Site Scripting](http://projects.webappsec.org/w/page/13246920/Cross%20Site%20Scripting)  

[OWASP: XSS Prevention Cheat Sheet](https://www.owasp.org/index.php/XSS_%28Cross_Site_Scripting%29_Prevention_Cheat_Sheet)  

[OWASP: Top 10 2013-A3: Cross-Site Scripting (XSS)](https://www.owasp.org/index.php/Top_10_2013-A3-Cross-Site_Scripting_%28XSS%29)  

[CWE-79: Improper Neutralization of Input During Web Page Generation ('Cross-site Scripting')](https://cwe.mitre.org/data/definitions/79.html)