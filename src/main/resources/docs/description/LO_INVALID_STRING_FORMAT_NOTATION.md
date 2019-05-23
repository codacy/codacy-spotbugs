# [Method attempts to log using String.format notation](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_INVALID_STRING_FORMAT_NOTATION)

This method attempts to use an SLF4J or Log4j2 logger to log a parameterized expression using String.format notation.
			However, SLF4J and Log4j2 uses simple non numbered anchors such as {}, rather than anchors with percent signs in them as the
			code uses. Thus no parameter replacement will occur.

This pattern is invalid:
			`LOGGER.error("%s is broken", theThing);`
			Use instead
			`LOGGER.error("{} is broken", theThing);`