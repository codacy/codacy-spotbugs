# [This method should use a StandardCharsets.XXX.name() to specify an encoding](http://fb-contrib.sourceforge.net/bugdescriptions.html#CSI_CHAR_SET_ISSUES_USE_STANDARD_CHARSET_NAME)

This method uses a hand-typed `String` literal to specify a `Charset` encoding. As this class is compiled
    		with JDK 7 (or better), and the charset in question is available as a constant from the
    		`java.nio.charset.StandardCharsets` class, it is better to use the .name() method of the appropriate
    		`StandardCharsets` constant.

The method in question doesn't directly support a `Charset` as a parameter, only a `String`.
			Still, instead of specifying something like "UTF-8" (and potentially mistyping it), use `StandardCharsets.UTF_8.name()`.