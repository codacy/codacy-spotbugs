# [Method fetches character array just to do the equivalent of the charAt method](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_CHARAT)

This method calls the toCharArray method on a String to fetch an array of characters, only
			to retrieve one of those characters by index. It is more performant to just use the charAt method.