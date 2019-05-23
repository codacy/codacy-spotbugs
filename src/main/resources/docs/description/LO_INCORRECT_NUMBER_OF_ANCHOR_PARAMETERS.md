# [Method passes an incorrect number of parameters to an SLF4J or Log4j2 logging statement](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_INCORRECT_NUMBER_OF_ANCHOR_PARAMETERS)

This method passes the wrong number of parameters to an SLF4J or Log4j2 logging method (error, warn, info, debug) based on the number of anchors {} in the
			format string. An additional exception argument is allowed if found.