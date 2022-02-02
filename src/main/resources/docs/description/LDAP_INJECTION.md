# [Potential LDAP Injection](https://find-sec-bugs.github.io/bugs.htm#LDAP_INJECTION)

Just like SQL, all inputs passed to an LDAP query need to be passed in safely. Unfortunately, LDAP doesn't have prepared statement interfaces like SQL.
Therefore, the primary defense against LDAP injection is strong input validation of any untrusted data before including it in an LDAP query.

    **Code at risk:**  

<pre>NamingEnumeration
 <searchresult>
   answers = context.search("dc=People,dc=example,dc=com",
        "(uid=" + username + ")", ctrls);
 </searchresult></pre>

**Solution:**

Safe evaluation of Java code using "StringUtils" library.  

<pre>if(StringUtils.isAlphanumeric(username)) {
    NamingEnumeration
 <searchresult>
   answers = context.search("dc=People,dc=example,dc=com",
        "(uid=" + username + ")", ctrls);
}
 </searchresult></pre>

**References**  

[LDAP Injection Prevention Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/LDAP_Injection_Prevention_Cheat_Sheet.html)  

[OWASP: Top 10 A1:2017-Injection](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A1-Injection)  

[WASC-29: LDAP Injection](http://projects.webappsec.org/w/page/13246947/LDAP%20Injection)  

[CWE-90: Improper Neutralization of Special Elements used in an LDAP Query ('LDAP Injection')](https://cwe.mitre.org/data/definitions/90.html)