# [Method compares string without case after enforcing a case](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USELESS_CASING)

This method compares two strings with compareToIgnoreCase or equalsIgnoreCase, after having
			called toUpperCase or toLowerCase on the strings in question. As you are comparing without
			concern for case, the toUpperCase or toLowerCase calls are pointless and can be removed.