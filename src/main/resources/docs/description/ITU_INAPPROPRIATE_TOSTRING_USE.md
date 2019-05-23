# [Method performs algorithmic operations on the result of a toString() call](http://fb-contrib.sourceforge.net/bugdescriptions.html#ITU_INAPPROPRIATE_TOSTRING_USE)

This method calls algorithmic operations on a String that was returned from a toString() method.
			As these methods are for debugging/logging purposes, it shouldn't be the basis of core logic in your code.