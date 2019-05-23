# [Method passes an empty string to equalsIgnoreCase or compareToIgnoreCase](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_EMPTY_CASING)

This method passes the empty string "" to equalsIgnoreCase or compareToIgnoreCase. As the empty string
			is not case-sensitive, using equals is simpler. It would be even simpler to do a length() == 0 test.