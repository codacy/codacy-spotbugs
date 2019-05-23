# [RequestDispatcher File Disclosure](http://find-sec-bugs.github.io/bugs.htm#REQUESTDISPATCHER_FILE_DISCLOSURE)

Constructing a server-side redirect path with user input could allow an attacker to download application binaries (including application classes or jar files) or view arbitrary files within protected directories.  

An attacker may be able to forge a request parameter to match sensitive file locations. For example, requesting `"http://example.com/?jspFile=../applicationContext.xml%3F"` would display the application's `applicationContext.xml` file. The attacker would be able to locate and download the `applicationContext.xml` referenced in the other configuration files, and even class files or jar files, obtaining sensitive information and launching other types of attacks.

    **Vulnerable Code:**  

<pre>...
String jspFile = request.getParameter("jspFile");
request.getRequestDispatcher("/WEB-INF/jsps/" + jspFile + ".jsp").include(request, response);
...</pre>

    **Solution:**  

Avoid constructing server-side redirects using user controlled input.

**References**  

[CWE-552: Files or Directories Accessible to External Parties](https://cwe.mitre.org/data/definitions/552.html)