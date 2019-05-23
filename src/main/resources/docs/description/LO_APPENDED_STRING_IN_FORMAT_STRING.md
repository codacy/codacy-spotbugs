# [Method passes a concatenated string to SLF4J's or Log4j2's format string](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_APPENDED_STRING_IN_FORMAT_STRING)

This method uses an SLF4J or Log4j2 logger to log a string, where the first (format) string is created using concatenation.
	       You should use {} markers to inject dynamic content into the string, so that String building is delayed until the
	       actual log string is needed. If the log level is high enough that this log statement isn't used, then the appends
	       will never be executed.