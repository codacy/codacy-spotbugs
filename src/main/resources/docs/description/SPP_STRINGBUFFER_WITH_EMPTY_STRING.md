# [Method passes an empty string to StringBuffer of StringBuilder constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_STRINGBUFFER_WITH_EMPTY_STRING)

This method calls the StringBuffer or StringBuilder constructor passing in a constant empty string ("").
			This is the same as calling the default constructor, but makes the code work harder. Consider passing in a
			default size instead.