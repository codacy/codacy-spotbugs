# [Potential external control of configuration](https://find-sec-bugs.github.io/bugs.htm#EXTERNAL_CONFIG_CONTROL)

    Allowing external control of system settings can disrupt service or cause an application
    to behave in unexpected, and potentially malicious ways.
    An attacker could cause an error by providing a nonexistent catalog name
    or connect to an unauthorized portion of the database.

**Code at risk:**  

<pre>conn.setCatalog(request.getParameter("catalog"));</pre>

    **References**  

    [CWE-15: External Control of System or Configuration Setting](https://cwe.mitre.org/data/definitions/15.html)