# [Potential code injection when using GroovyShell](https://find-sec-bugs.github.io/bugs.htm#GROOVY_SHELL)

    A expression is built with a dynamic value. The source of the value(s) should be verified to avoid
    that unfiltered values fall into this risky code evaluation.

**Code at risk:**

<pre>
public void evaluateScript(String script) {
  GroovyShell shell = new GroovyShell();
  shell.evaluate(script);
}
</pre>

**Solution:**

In general, method evaluating Groovy expression should not receive user input from low privilege users.

    **References**  

    [Hacking Jenkins Part 2 - Abusing Meta Programming for Unauthenticated RCE!](https://blog.orange.tw/2019/02/abusing-meta-programming-for-unauthenticated-rce.html) by Orange Tsai  

    [Jenkins RCE payloads](https://github.com/orangetw/awesome-jenkins-rce-2019) by Orange Tsai  

    [POC for CVE-2019-1003001](https://github.com/adamyordan/cve-2019-1003000-jenkins-rce-poc) by Adam Jordan  

    [Various payloads of exploiting Groovy code evaluation](https://github.com/welk1n/exploiting-groovy-in-Java/)