# [Potential injection (custom)](https://find-sec-bugs.github.io/bugs.htm#CUSTOM_INJECTION)

The method identified is susceptible to injection. The input should be validated and properly escaped.

    **Vulnerable code samples:**  

<pre>SqlUtil.execQuery("select * from UserEntity t where id = " + parameterInput);</pre>

    Refer to the online wiki for detailed instructions on [how to configure custom signatures](https://github.com/find-sec-bugs/find-sec-bugs/wiki/Custom-signatures).

**References**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)