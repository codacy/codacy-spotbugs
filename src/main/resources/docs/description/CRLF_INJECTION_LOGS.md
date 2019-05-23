# [Potential CRLF Injection for logs](http://find-sec-bugs.github.io/bugs.htm#CRLF_INJECTION_LOGS)

    When data from an untrusted source is put into a logger and not neutralized correctly,
    an attacker could forge log entries or include malicious content.
    Inserted false entries could be used to skew statistics, distract the administrator
    or even to implicate another party in the commission of a malicious act.
    If the log file is processed automatically, the attacker can render the file unusable
    by corrupting the format of the file or injecting unexpected characters.
    An attacker may also inject code or other commands into the log file and take advantage
    of a vulnerability in the log processing utility (e.g. command injection or XSS).

**Code at risk:**  

<pre>String val = request.getParameter("user");
String metadata = request.getParameter("metadata");
[...]
if(authenticated) {
    log.info("User " + val + " (" + metadata + ") was authenticated successfully");
}
else {
    log.info("User " + val + " (" + metadata + ") was not authenticated");
}
</pre>

A malicious user could send the metadata parameter with the value: `"Firefox) was authenticated successfully\r\n[INFO] User bbb (Internet Explorer"`.

**Solution:**  

You can manually sanitize each parameter.

<pre>
log.info("User " + val.replaceAll("[\r\n]","") + " (" + userAgent.replaceAll("[\r\n]","") + ") was not authenticated");
</pre>

You can also configure your logger service to replace new line for all message events. Here is sample configuration for LogBack [using the `replace` function](https://logback.qos.ch/manual/layouts.html#replace).

<pre>

 <pattern>
  %-5level - %replace(%msg){'[\r\n]', ''}%n
 </pattern>
</pre>

Finally, you can use a logger implementation that replace new line by spaces.
The project [OWASP Security Logging](https://github.com/javabeanz/owasp-security-logging) has an implementation for Logback and Log4j.

    **References**  

    [CWE-117: Improper Output Neutralization for Logs](http://cwe.mitre.org/data/definitions/117.html)  

    [CWE-93: Improper Neutralization of CRLF Sequences ('CRLF Injection')](http://cwe.mitre.org/data/definitions/93.html)  

    [CWE-93: Improper Neutralization of CRLF Sequences ('CRLF Injection')](https://logback.qos.ch/manual/layouts.html#replace)  

    [OWASP Security Logging](https://github.com/javabeanz/owasp-security-logging)