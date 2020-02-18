# [Potential Android SQL Injection](https://find-sec-bugs.github.io/bugs.htm#SQL_INJECTION_ANDROID)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.

    **Vulnerable Code:**  

<pre>String query = "SELECT * FROM  messages WHERE uid= '"+userInput+"'" ;
Cursor cursor = this.getReadableDatabase().rawQuery(query,null);</pre>

    **Solution:**  

<pre>String query = "SELECT * FROM  messages WHERE uid= ?" ;
Cursor cursor = this.getReadableDatabase().rawQuery(query,new String[] {userInput});</pre>

**References (Android SQLite)**  

[InformIT.com: Practical Advice for Building Secure Android Databases in SQLite](http://www.informit.com/articles/article.aspx?p=2268753&seqNum=5)  

[Packtpub.com: Knowing the SQL-injection attacks and securing our Android applications from them](https://www.packtpub.com/books/content/knowing-sql-injection-attacks-and-securing-our-android-applications-them)  

[Android Database Support (Enterprise Android: Programming Android Database Applications for the Enterprise)](https://books.google.ca/books?id=SXlMAQAAQBAJ&lpg=PR1&pg=PA64#v=onepage&q&f=false)  

[Safe example of Insert, Select, Update and Delete queries provided by Suragch](https://stackoverflow.com/a/29797229/89769)  

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)