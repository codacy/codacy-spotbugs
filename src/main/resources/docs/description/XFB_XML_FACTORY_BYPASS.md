# [Method directly allocates a specific implementation of xml interfaces](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#XFB_XML_FACTORY_BYPASS)

      This method allocates a specific implementation of an xml interface. It is preferable to use
      the supplied factory classes to create these objects so that the implementation can be
      changed at runtime. See

*   javax.xml.parsers.DocumentBuilderFactory
*   javax.xml.parsers.SAXParserFactory
*   javax.xml.transform.TransformerFactory
*   org.w3c.dom.Document.create_XXXX_

for details.