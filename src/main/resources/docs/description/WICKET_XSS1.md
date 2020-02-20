# [Disabling HTML escaping put the application at risk for XSS](https://find-sec-bugs.github.io/bugs.htm#WICKET_XSS1)

Disabling HTML escaping put the application at risk for Cross-Site Scripting (XSS).

**Vulnerable Code:**  

<pre>
add(new Label("someLabel").setEscapeModelStrings(false));
</pre>

**References**  

[Wicket models and forms - Reference Documentation](https://ci.apache.org/projects/wicket/guide/6.x/guide/modelsforms.html)  

[WASC-8: Cross Site Scripting](http://projects.webappsec.org/w/page/13246920/Cross%20Site%20Scripting)  

[OWASP: XSS Prevention Cheat Sheet](https://www.owasp.org/index.php/XSS_%28Cross_Site_Scripting%29_Prevention_Cheat_Sheet)  

[OWASP: Top 10 2013-A3: Cross-Site Scripting (XSS)](https://www.owasp.org/index.php/Top_10_2013-A3-Cross-Site_Scripting_%28XSS%29)  

[CWE-79: Improper Neutralization of Input During Web Page Generation ('Cross-site Scripting')](https://cwe.mitre.org/data/definitions/79.html)