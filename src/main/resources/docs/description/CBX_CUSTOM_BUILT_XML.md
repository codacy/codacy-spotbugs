# [Method builds XML strings through ad hoc concatenation](http://fb-contrib.sourceforge.net/bugdescriptions.html#CBX_CUSTOM_BUILT_XML)

This method generates an XML based string by concatenating together various
			XML fragments, and variable values. Doing so makes the code difficult to read, modify
			and validate. It is much cleaner to build XML structures in external files that are
			read in and transformed into the final product, through modification by Transformer.setParameter.