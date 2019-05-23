# [This method uses an unknown character encoding literal](http://fb-contrib.sourceforge.net/bugdescriptions.html#CSI_CHAR_SET_ISSUES_UNKNOWN_ENCODING)

This method specifies a `Charset` encoding with a String literal that is not recognized by the current
    		JDK. It's possible that this application will only be deployed on a JVM that does recognize this encoding, but
    		it seems dubious that this is the case.

    		The standard JDK encodings (for Java 8) are "UTF-8", "US-ASCII", "ISO-8859-1", "UTF-16BE", "UTF-16LE", "UTF-16".  These are all case-sensitive.