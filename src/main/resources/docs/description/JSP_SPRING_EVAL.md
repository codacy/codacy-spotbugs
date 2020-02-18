# [Dynamic variable in Spring expression](https://find-sec-bugs.github.io/bugs.htm#JSP_SPRING_EVAL)

A Spring expression is built with a dynamic value. The source of the value(s) should be verified to avoid that unfiltered values fall into this risky code evaluation.

    **Vulnerable Code:**

<pre>&lt;%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %&gt;

 <spring:eval expression="${param.lang}" var="lang" /></pre>

<pre>&lt;%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %&gt;

 <spring:eval expression="'${param.lang}'=='fr'" var="languageIsFrench" /></pre>

    **Solution:**

<pre>
 <c:set var="lang" value="${param.lang}" /></pre>

<pre>
 <c:set var="languageIsFrench" value="${param.lang == 'fr'}" /></pre>

**References**  

    [CWE-94: Improper Control of Generation of Code ('Code Injection')](https://cwe.mitre.org/data/definitions/94.html)  

    [CWE-95: Improper Neutralization of Directives in Dynamically Evaluated Code ('Eval Injection')](https://cwe.mitre.org/data/definitions/95.html)