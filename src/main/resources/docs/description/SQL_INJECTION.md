# [Potential SQL Injection](https://find-sec-bugs.github.io/bugs.htm#SQL_INJECTION)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.
Alternatively to prepare statements, each parameter can be escaped manually.

    **Vulnerable Code:**  

<pre>
createQuery("select * from User where id = '"+inputId+"'");
</pre>

    **Solution:**  

<pre>
import org.owasp.esapi.Encoder;

createQuery("select * from User where id = '"+Encoder.encodeForSQL(inputId)+"'");
</pre>

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)