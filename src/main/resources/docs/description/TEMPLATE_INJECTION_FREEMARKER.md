# [Potential template injection with Freemarker](https://find-sec-bugs.github.io/bugs.htm#TEMPLATE_INJECTION_FREEMARKER)

Freemarker template engine is powerful. It is possible to add logic including condition statements, loops and external calls.
It is not design to be sandbox to templating operations. A malicious user in control of a template can run malicious code
on the server-side. Freemarker templates should be seen as scripts.

    **Vulnerable Code:**

<pre>Template template = cfg.getTemplate(inputTemplate);
[...]
template.process(data, swOut);</pre>

    **Solution:**

Avoid letting end users manipulate templates with Freemarker. If you need to expose template editing to your users,
prefer logic-less template engines such as Handlebars or Moustache (See references).

**References**  

[PortSwigger: Server-Side Template Injection](https://portswigger.net/research/server-side-template-injection)  

[Handlebars.java](https://jknack.github.io/handlebars.java/)