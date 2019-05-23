# [Method checks a reference for null before calling instanceof](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_NULL_BEFORE_INSTANCEOF)

This method checks a reference for null just before seeing if the reference is an instanceof some class.
			Since instanceof will return false for null references, the null check is not needed.