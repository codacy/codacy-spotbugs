# [Potential SQL Injection with Vert.x Sql Client](https://find-sec-bugs.github.io/bugs.htm#SQL_INJECTION_VERTX)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.
Vert.x Sql Client API provide a DSL to build query with Java code.

    **Vulnerable Code:**  

<pre>
SqlClient.query( "select * from Customer where id=" + inputId ).execute(ar -&gt; ...);
</pre>

    **Solution (using Prepared Statements):**  

<pre>
client
    .preparedQuery( "SELECT * FROM users WHERE id=$1" )
    .execute(Tuple.of("julien"))
    .onSuccess(rows -&gt; ...)
    .onFailure(err -&gt; ...);
</pre>

**References (Vert.x Sql Client)**  

[Vertx Database Access Documentation](https://vertx.io/docs/#databases)  

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)