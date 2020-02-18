# [Potential template injection with Pebble](https://find-sec-bugs.github.io/bugs.htm#TEMPLATE_INJECTION_PEBBLE)

Pebble template engine is powerful. It is possible to add logic including condition statements, loops and external calls.
It is not design to be sandbox to templating operations. A malicious user in control of a template can run malicious code
on the server-side. Pebble templates should be seen as scripts.

    **Vulnerable Code:**

<pre>PebbleTemplate compiledTemplate = engine.getLiteralTemplate(inputFile);
[...]
compiledTemplate.evaluate(writer, context);</pre>

    **Solution:**

Avoid letting end users manipulate templates with Pebble. If you need to expose template editing to your users,
prefer logic-less template engines such as Handlebars or Moustache (See references).

**References**  

[Server Side Template Injection – on the example of Pebble](https://research.securitum.com/server-side-template-injection-on-the-example-of-pebble/) by Michał Bentkowski  

[PortSwigger: Server-Side Template Injection](https://portswigger.net/research/server-side-template-injection)  

[Handlebars.java](https://jknack.github.io/handlebars.java/)