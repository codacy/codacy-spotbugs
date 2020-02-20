# [Cookie without the HttpOnly flag](https://find-sec-bugs.github.io/bugs.htm#HTTPONLY_COOKIE)

A new cookie is created without the `HttpOnly` flag set.
The `HttpOnly` flag is a directive to the browser to make sure that the cookie can not be red by
malicious script. When a user is the target of a "Cross-Site Scripting", the attacker would benefit greatly from getting
the session id for example.

**Code at risk:**  

<pre>
Cookie cookie = new Cookie("email",userName);
response.addCookie(cookie);
</pre>

**Solution (Specific configuration):**  

<pre>
Cookie cookie = new Cookie("email",userName);
cookie.setSecure(true);
cookie.setHttpOnly(true); //HttpOnly flag
</pre>

**Solution (Servlet 3.0 configuration):**  

<pre>

 <web-app xmlns="http://java.sun.com/xml/ns/javaee" version="3.0">

[...]

  <session-config> 
   <cookie-config> 
    <http-only>
     true
    </http-only> 
    <secure>
     true
    </secure> 
   </cookie-config> 
  </session-config>

 </web-app>
</pre>

**Reference**  

[Coding Horror blog: Protecting Your Cookies: HttpOnly](https://blog.codinghorror.com/protecting-your-cookies-httponly/)  

[OWASP: HttpOnly](https://www.owasp.org/index.php/HttpOnly)  

[Rapid7: Missing HttpOnly Flag From Cookie](https://www.rapid7.com/db/vulnerabilities/http-cookie-http-only-flag)