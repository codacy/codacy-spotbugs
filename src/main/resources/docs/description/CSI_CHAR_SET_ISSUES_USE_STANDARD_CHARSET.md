# [This method needlessly uses a String literal as a Charset encoding](http://fb-contrib.sourceforge.net/bugdescriptions.html#CSI_CHAR_SET_ISSUES_USE_STANDARD_CHARSET)

This method uses a string literal to specify a `Charset` encoding. However, the method invoked has an
    		alternative signature that takes a `Charset` object. You should use this signature, as this class is compiled
    		with JDK 7 (or better), and the `Charset` in question is available as a constant from the
    		`java.nio.charset.StandardCharsets` class.

Instead of specifying "UTF-8", use `StandardCharsets.UTF_8`, for instance. An added benefit of this is
    		that you will not need to catch `UnsupportedEncodingException`.