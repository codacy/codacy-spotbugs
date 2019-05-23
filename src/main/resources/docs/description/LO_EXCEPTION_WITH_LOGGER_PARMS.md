# [Method creates exception with logger parameter markers in message](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_EXCEPTION_WITH_LOGGER_PARMS)

This method passes a standard exception as a logger parameter, and expects this exception to be substituted in
	        an SLF4J or Log4j style parameter marker '{}'. This marker will not be translated as SLF4J and Log4j2 don't process the Exception
	        class for markers.