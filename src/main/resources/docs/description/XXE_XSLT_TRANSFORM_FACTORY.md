# [XSLT parsing vulnerable to XXE (TransformerFactory)](https://find-sec-bugs.github.io/bugs.htm#XXE_XSLT_TRANSFORM_FACTORY)

[###ERROR: 
<!--XXE_GENERIC_START--> ###]

### Attack

XSLT External Entity (XXE) attacks can occur when an XSLT parser supports external entities while processing XSLT received
from an untrusted source.

**Risk: Expose local file content (XXE: <u>X</u>ML E<u>x</u>ternal <u>E</u>ntity)**

<pre>

 <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/"> 
   <xsl:value-of select="document('/etc/passwd')"> 
   </xsl:value-of>
  </xsl:template>

 </xsl:stylesheet></pre>

### Solution

In order to avoid exposing dangerous feature of the XML parser, you can do the following change to the code.

[###ERROR: 
<!--XXE_GENERIC_END--> ###]

**Vulnerable Code:**

<pre>
Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.transform(input, result);</pre>

The following snippets show two available solutions. You can set one feature or both.

**Solution disabling DTD:**

This setting will protect you against remote file access but not denial of service.

<pre>
TransformerFactory factory = TransformerFactory.newInstance();
factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

Transformer transformer = factory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

transformer.transform(input, result);</pre>

An empty string denies all access to external references for both attributes.

**Solution using "Secure processing" mode:**

This setting will protect you against remote file access but not denial of service.

<pre>
TransformerFactory factory = TransformerFactory.newInstance();
factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

Transformer transformer = factory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

transformer.transform(input, result);</pre>

**References**  

[###ERROR: 
<!--XXE_GENERIC_START--> ###]
[CWE-611: Improper Restriction of XML External Entity Reference ('XXE')](https://cwe.mitre.org/data/definitions/611.html)  

[CERT: IDS10-J. Prevent XML external entity attacks](https://www.securecoding.cert.org/confluence/pages/viewpage.action?pageId=61702260)  

[OWASP.org: XML External Entity (XXE) Processing](https://www.owasp.org/index.php/XML_External_Entity_%28XXE%29_Processing)  

[WS-Attacks.org: XML Entity Expansion](https://www.ws-attacks.org/index.php/XML_Entity_Expansion)  

[WS-Attacks.org: XML External Entity DOS](https://www.ws-attacks.org/index.php/XML_External_Entity_DOS)  

[WS-Attacks.org: XML Entity Reference Attack](https://www.ws-attacks.org/index.php/XML_Entity_Reference_Attack)  

[Identifying XML External Entity vulnerability (XXE)](https://blog.h3xstream.com/2014/06/identifying-xml-external-entity.html)  

[###ERROR: 
<!--XXE_GENERIC_END--> ###]