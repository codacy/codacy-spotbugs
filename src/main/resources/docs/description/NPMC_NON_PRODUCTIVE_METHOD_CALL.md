# [Method ignores return value of a non mutating method](http://fb-contrib.sourceforge.net/bugdescriptions.html#NPMC_NON_PRODUCTIVE_METHOD_CALL)

This method ignores the return value of a common method that is assumed to be non-mutating.
			If this method does in fact not modify the object it is called on, there is no reason to call
			this method, and it can be removed.