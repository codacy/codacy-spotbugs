# [Potential code injection when using OGNL expression](http://find-sec-bugs.github.io/bugs.htm#OGNL_INJECTION)

    A expression is built with a dynamic value. The source of the value(s) should be verified to avoid
    that unfiltered values fall into this risky code evaluation.

**Code at risk:**

<pre>
public void getUserProperty(String property) {
  [...]
  //The first argument is the dynamic expression.
  return ognlUtil.getValue("user."+property, ctx, root, String.class);
}
</pre>

**Solution:**

In general, method evaluating OGNL expression should not receive user input. It is intended to be used in static configurations and JSP.

    **References**  

    [HP Enterprise: Struts 2 OGNL Expression Injections by Alvaro MuÃ±oz](https://community.saas.hpe.com/t5/Security-Research/Struts-2-OGNL-Expression-Injections/ba-p/288881)  

    [Gotham Digital Science: An Analysis Of CVE-2017-5638](https://blog.gdssecurity.com/labs/2017/3/27/an-analysis-of-cve-2017-5638.html)  

    [Apache Struts2: Vulnerability S2-016](http://struts.apache.org/docs/s2-016.html)  

    [Apache Struts 2 Documentation: OGNL](https://struts.apache.org/docs/ognl.html)