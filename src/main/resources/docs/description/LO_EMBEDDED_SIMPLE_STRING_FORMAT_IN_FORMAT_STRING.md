# [Method passes a simple String.format result to an SLF4J's or Log4j2's format string](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_EMBEDDED_SIMPLE_STRING_FORMAT_IN_FORMAT_STRING)

This method uses an SLF4J or Log4J2 logger to log a string which was produced through a call to String.format, where
	       the format string passed was a constant string containing only simple format markers that could be directly handled
	       by SLF4J or Log4J. Rather than doing

<pre>
	          logger.error(String.format("This %s is an error", s));

<pre>
	       do

<pre>
	          logger.error("This {} is an error", s);
	       </pre>

</pre>

</pre>