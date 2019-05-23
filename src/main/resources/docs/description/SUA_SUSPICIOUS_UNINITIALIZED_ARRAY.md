# [Method returns an array that appears not to be initialized](http://fb-contrib.sourceforge.net/bugdescriptions.html#SUA_SUSPICIOUS_UNINITIALIZED_ARRAY)

This method returns an array that was allocated but apparently not initialized. It is
			possible that the caller of this method will do the work of initializing this array, but
			that is not a common pattern, and it is assumed that this array has just been forgotten to
			be initialized.