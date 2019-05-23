 The method [`HttpServletRequest.getRequestedSessionId()`](http://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html#getRequestedSessionId())typically returns the value of the cookie `JSESSIONID`. This value is normally only accessed by the session management logic and not normal developer code.

The value passed to the client is generally an alphanumeric value (e.g., `JSESSIONID=jp6q31lq2myn`). However, the value can be altered by the client. The following HTTP request illustrates the potential modification.

```
GET /somePage HTTP/1.1
Host: yourwebsite.com
User-Agent: Mozilla/5.0
Cookie: JSESSIONID=Any value of the user's choice!!??'''">
```

As such, the JSESSIONID should only be used to see if its value matches an existing session ID. If it does not, the user should be considered an unauthenticated user. In addition, the session ID value should never be logged. If it is, then the log file could contain valid active session IDs, allowing an insider to hijack any sessions whose IDs have been logged and are still active.

  

**References**  
[OWASP: Session Management Cheat Sheet](https://www.owasp.org/index.php/Session_Management_Cheat_Sheet)  
[CWE-20: Improper Input Validation](http://cwe.mitre.org/data/definitions/20.html)

