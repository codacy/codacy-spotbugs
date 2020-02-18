# [A malicious XSLT could be provided to the JSP tag](https://find-sec-bugs.github.io/bugs.htm#JSP_XSLT)

    "XSLT (Extensible Stylesheet Language Transformations) is a language for transforming XML documents into other XML documents".<sup>[1]</sup>  

    It is possible to attach malicious behavior to those style sheets. Therefore, if an attacker can control the content or the source of the
    style sheet, he might be able to trigger remote code execution.<sup>[2]</sup>

**Code at risk:**  

<pre>

 <x:transform xml="${xmlData}" xslt="${xsltControlledByUser}" />
</pre>

**Solution:**  

The solution would be to make sure the style sheet is loaded from a safe sources and make sure that vulnerabilities such as
Path traversal <sup>[3][4]</sup> are not possible.

**References**  

[1] [Wikipedia: XSLT (Extensible Stylesheet Language Transformations)](https://en.wikipedia.org/wiki/XSLT)  

[Offensive XSLT](https://prezi.com/y_fuybfudgnd/offensive-xslt/) by Nicolas Grégoire  

[2] [From XSLT code execution to Meterpreter shells](https://www.agarri.fr/blog/archives/2012/07/02/from_xslt_code_execution_to_meterpreter_shells/index.html) by Nicolas Grégoire  

[XSLT Hacking Encyclopedia](https://xhe.myxwiki.org/xwiki/bin/view/Main/) by Nicolas Grégoire  

[Acunetix.com : The hidden dangers of XSLTProcessor - Remote XSL injection](https://www.acunetix.com/blog/articles/the-hidden-dangers-of-xsltprocessor-remote-xsl-injection/)  

[w3.org XSL Transformations (XSLT) Version 1.0](https://www.w3.org/TR/xslt) : w3c specification  

[3] [WASC: Path Traversal](http://projects.webappsec.org/w/page/13246952/Path%20Traversal)  

[4] [OWASP: Path Traversal](https://www.owasp.org/index.php/Path_Traversal)