# [Method attempts to access an array element outside the array's size](http://fb-contrib.sourceforge.net/bugdescriptions.html#AIOB_ARRAY_INDEX_OUT_OF_BOUNDS)

This method accesses an array element using a literal index that is known to be outside the size
			of the specified array. This will cause an ArrayIndexOutOfBoundsException at runtime.