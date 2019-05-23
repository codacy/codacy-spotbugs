# [URLConnection Server-Side Request Forgery (SSRF) and File Disclosure](http://find-sec-bugs.github.io/bugs.htm#URLCONNECTION_SSRF_FD)

    Server-Side Request Forgery occur when a web server executes a request to a user supplied destination
    parameter that is not validated. Such vulnerabilities could allow an attacker to access internal services
    or to launch attacks from your web server.

    URLConnection can be used with file:// protocol or other protocols to access local filesystem and potentially other services.

    **Vulnerable Code:**

<pre>
new URL(String url).openConnection()
new URL(String url).openStream()
new URL(String url).getContent()
</pre>

    **Solution/Countermeasures:**  

*   Don't accept URL destinations from users
*   Accept a destination key, and use it to look up the target (legal) destination
*   White list URLs (if possible)
*   Validate that the beginning of the URL is part of a white list

**References**  

[CWE-918: Server-Side Request Forgery (SSRF)](https://cwe.mitre.org/data/definitions/918.html)  

[Understanding Server-Side Request Forgery](https://www.bishopfox.com/blog/2015/04/vulnerable-by-design-understanding-server-side-request-forgery/)  

[CWE-73: External Control of File Name or Path](https://cwe.mitre.org/data/definitions/73.html)  

[Abusing jar:// downloads](https://www.pwntester.com/blog/2013/11/28/abusing-jar-downloads/)