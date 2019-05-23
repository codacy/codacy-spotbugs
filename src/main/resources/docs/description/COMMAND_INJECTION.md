# [Potential Command Injection](http://find-sec-bugs.github.io/bugs.htm#COMMAND_INJECTION)

The highlighted API is used to execute a system command. If unfiltered input is passed to this API, it can lead to arbitrary command execution.

    **Vulnerable Code:**  

<pre>import java.lang.Runtime;

Runtime r = Runtime.getRuntime();
r.exec("/bin/sh -c some_tool" + input);</pre>

**References**  

[OWASP: Command Injection](https://www.owasp.org/index.php/Command_Injection)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[CWE-78: Improper Neutralization of Special Elements used in an OS Command ('OS Command Injection')](http://cwe.mitre.org/data/definitions/78.html)