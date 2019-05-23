# [Method encodes String bytes without specifying the character encoding](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_STRING_BYTES_ENCODING)

The behavior of the `String(byte[] bytes)` and `String.getBytes()` is undefined if the string cannot be encoded in the platform's default charset. Instead, use the `String(byte[] bytes, String encoding)` or `String.getBytes(String encoding)` constructor which accepts the string's encoding as an argument. Be sure to specify the encoding used for the user's locale.

As per the Java specifications, "UTF-8", "US-ASCII", "UTF-16" and "ISO-8859-1" will all be valid [encoding charsets](http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#standard).  If you aren't sure, try "UTF-8".

**New in Java 1.7**, you can specify an encoding from `StandardCharsets`, like `StandardCharsets.UTF_8`.  These are generally preferrable because you don't have to deal with `UnsupportedEncodingException`.