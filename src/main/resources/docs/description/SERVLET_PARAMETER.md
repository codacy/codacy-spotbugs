# [Untrusted servlet parameter](http://find-sec-bugs.github.io/bugs.htm#SERVLET_PARAMETER)

The Servlet can read GET and POST parameters from various methods. The value obtained should be considered unsafe.
You may need to validate or sanitize those values before passing them to sensitive APIs such as:

*   SQL query (May leads to SQL injection)
*   File opening (May leads to path traversal)
*   Command execution (Potential Command injection)
*   HTML construction (Potential XSS)
*   etc...

**Reference**  

[CWE-20: Improper Input Validation](http://cwe.mitre.org/data/definitions/20.html)