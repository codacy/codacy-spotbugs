# [Potential JDBC Injection (Spring JDBC)](https://find-sec-bugs.github.io/bugs.htm#SQL_INJECTION_SPRING_JDBC)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.

    **Vulnerable Code:**  

<pre>JdbcTemplate jdbc = new JdbcTemplate();
int count = jdbc.queryForObject("select count(*) from Users where name = '"+paramName+"'", Integer.class);
</pre>

    **Solution:**  

<pre>JdbcTemplate jdbc = new JdbcTemplate();
int count = jdbc.queryForObject("select count(*) from Users where name = ?", Integer.class, paramName);</pre>

**References (Spring JDBC)**  

[Spring Official Documentation: Data access with JDBC](https://spring.io/guides/gs/relational-data-access/)  

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)