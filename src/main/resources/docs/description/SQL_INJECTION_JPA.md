# [Potential SQL/JPQL Injection (JPA)](https://find-sec-bugs.github.io/bugs.htm#SQL_INJECTION_JPA)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.

    **Vulnerable Code:**  

<pre>
EntityManager pm = getEM();

TypedQuery
 <userentity>
   q = em.createQuery(
    String.format("select * from Users where name = %s", username),
    UserEntity.class);

UserEntity res = q.getSingleResult();
 </userentity></pre>

    **Solution:**  

<pre>
TypedQuery
 <userentity>
   q = em.createQuery(
    "select * from Users where name = usernameParam",UserEntity.class)
    .setParameter("usernameParam", username);

UserEntity res = q.getSingleResult();
 </userentity></pre>

**References (JPA)**  

[The Java EE 6 Tutorial: Creating Queries Using the Java Persistence Query Language](https://docs.oracle.com/javaee/6/tutorial/doc/bnbrg.html)  

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)