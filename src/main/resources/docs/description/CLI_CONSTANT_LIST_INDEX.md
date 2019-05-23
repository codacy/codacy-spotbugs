# [Method accesses list or array with constant index](http://fb-contrib.sourceforge.net/bugdescriptions.html#CLI_CONSTANT_LIST_INDEX)

This method accesses an array or list using a constant integer index. Often,
			this is a typo where a loop variable is intended to be used. If however, specific
			list indices mean different specific things, then perhaps replacing the list with
			a first-class object with meaningful accessors would make the code less brittle.