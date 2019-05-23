# [Potential code injection when using Spring Expression](http://find-sec-bugs.github.io/bugs.htm#SPEL_INJECTION)

    A Spring expression is built with a dynamic value. The source of the value(s) should be verified to avoid
    that unfiltered values fall into this risky code evaluation.

**Code at risk:**

<pre>
public void parseExpressionInterface(Person personObj,String property) {

        ExpressionParser parser = new SpelExpressionParser();

        //Unsafe if the input is control by the user..
        Expression exp = parser.parseExpression(property+" == 'Albert'");

        StandardEvaluationContext testContext = new StandardEvaluationContext(personObj);
        boolean result = exp.getValue(testContext, Boolean.class);
[...]</pre>

    **References**  

    [CWE-94: Improper Control of Generation of Code ('Code Injection')](http://cwe.mitre.org/data/definitions/94.html)  

    [CWE-95: Improper Neutralization of Directives in Dynamically Evaluated Code ('Eval Injection')](http://cwe.mitre.org/data/definitions/95.html)  

    [Spring Expression Language (SpEL) - Official Documentation](http://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/expressions.html)  

    [Minded Security: Expression Language Injection](https://www.mindedsecurity.com/fileshare/ExpressionLanguageInjection.pdf)  

    [Remote Code Execution .. by design](http://blog.h3xstream.com/2014/11/remote-code-execution-by-design.html): Example of malicious payload. The samples given could be used to test sandboxing rules.  

    [Spring Data-Commons: (CVE-2018-1273)](https://gosecure.net/2018/05/15/beware-of-the-magic-spell-part-1-cve-2018-1273/)  

    [Spring OAuth2: CVE-2018-1260](http://gosecure.net/2018/05/17/beware-of-the-magic-spell-part-2-cve-2018-1260/)