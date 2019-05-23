# [Method overly synchronizes a block of code](http://fb-contrib.sourceforge.net/bugdescriptions.html#BSB_BLOATED_SYNCHRONIZED_BLOCK)

This method implements a synchronized block, but the code found at the beginning
			of this block only accesses local variables, and not member variables or `this`.
			For better performance, move the code that accesses local variables only above the
			synchronized block, and leave the synchronized block only for field accesses, or access
			to `this`.