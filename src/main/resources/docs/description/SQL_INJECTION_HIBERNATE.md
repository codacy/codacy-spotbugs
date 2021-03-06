# [Potential SQL/HQL Injection (Hibernate)](https://find-sec-bugs.github.io/bugs.htm#SQL_INJECTION_HIBERNATE)

The input values included in SQL queries need to be passed in safely.
Bind variables in prepared statements can be used to easily mitigate the risk of SQL injection.
Alternatively to prepare statements, Hibernate Criteria can be used.

    **Vulnerable Code:**  

<pre>
Session session = sessionFactory.openSession();
Query q = session.createQuery("select t from UserEntity t where id = " + input);
q.execute();</pre>

    **Solution:**  

<pre>
Session session = sessionFactory.openSession();
Query q = session.createQuery("select t from UserEntity t where id = :userId");
q.setString("userId",input);
q.execute();</pre>

    **Solution for dynamic queries (with Hibernate Criteria):**  

<pre>
Session session = sessionFactory.openSession();
Query q = session.createCriteria(UserEntity.class)
    .add( Restrictions.like("id", input) )
    .list();
q.execute();</pre>

**References (Hibernate)**  

[CWE-564: SQL Injection: Hibernate](https://cwe.mitre.org/data/definitions/564.html)  

[Hibernate Documentation: Query Criteria](https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/querycriteria.html)  

[Hibernate Javadoc: Query Object](https://docs.jboss.org/hibernate/orm/3.2/api/org/hibernate/Query.html)  

[HQL for pentesters](https://blog.h3xstream.com/2014/02/hql-for-pentesters.html): Guideline to test if the suspected code is exploitable.  

**References (SQL injection)**  

[WASC-19: SQL Injection](http://projects.webappsec.org/w/page/13246963/SQL%20Injection)  

[CAPEC-66: SQL Injection](https://capec.mitre.org/data/definitions/66.html)  

[CWE-89: Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')](https://cwe.mitre.org/data/definitions/89.html)  

[OWASP: Top 10 2013-A1-Injection](https://www.owasp.org/index.php/Top_10_2013-A1-Injection)  

[OWASP: SQL Injection Prevention Cheat Sheet](https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet)  

[OWASP: Query Parameterization Cheat Sheet](https://www.owasp.org/index.php/Query_Parameterization_Cheat_Sheet)