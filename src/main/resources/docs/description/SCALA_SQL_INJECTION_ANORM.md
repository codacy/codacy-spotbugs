# [Potential Scala Anorm Injection](https://find-sec-bugs.github.io/bugs.htm#SCALA_SQL_INJECTION_ANORM)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.

    **Vulnerable Code:**  

<pre>val peopleParser = Macro.parser[Person]("id", "name", "age")

DB.withConnection { implicit c =&gt;
  val people: List[Person] = SQL("select * from people where name = '" + value + "'").as(peopleParser.*)
}</pre>

    **Solution:**  

<pre>val peopleParser = Macro.parser[Person]("id", "name", "age")

DB.withConnection { implicit c =&gt;
  val people: List[Person] = SQL"select * from people where name = $value".as(peopleParser.*)
}</pre>

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)