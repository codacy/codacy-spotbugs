# [Method attempts to log using numbered formatting anchors](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_INVALID_FORMATTING_ANCHOR)

This method attempts to use an SLF4J or Log4j2 logger to log a parameterized expression using formatting anchors.
			However, SLF4J and Log4j2 use simple non numbered anchors such as {}, rather than anchors with digits in them as the
			code uses. Thus no parameter replacement will occur.

This pattern is invalid:
			`LOGGER.error("{0} is broken", theThing);`
			Use instead
			`LOGGER.error("{} is broken", theThing);`