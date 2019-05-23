# [Method calls intern on a string constant](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_INTERN_ON_CONSTANT)

This method calls `intern` on a constant string. As constant strings are already interned, this call
			is superfluous.