# [Method concatenates an empty string to effect type conversion](http://fb-contrib.sourceforge.net/bugdescriptions.html#ISB_EMPTY_STRING_APPENDING)

This method concatenates an empty string with a literal value, in order to convert
			the literal value into a string. It is more efficient to use String.valueOf() to do the same
			thing as you do not incur the cost of creating a StringBuffer/Builder and calling methods on it
			to accomplish this.