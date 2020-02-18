# [Potentially sensitive data in a cookie](https://find-sec-bugs.github.io/bugs.htm#COOKIE_USAGE)

The information stored in a custom cookie should not be sensitive or related to the session. In most cases, sensitive data should only be stored in session
and referenced by the user's session cookie. See HttpSession (`HttpServletRequest.getSession()`)

Custom cookies can be used for information that needs to live longer than and is independent of a specific session.

**Reference**  

[CWE-315: Cleartext Storage of Sensitive Information in a Cookie](https://cwe.mitre.org/data/definitions/315.html)