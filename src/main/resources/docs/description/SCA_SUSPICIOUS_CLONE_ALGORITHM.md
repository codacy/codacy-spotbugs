# [Clone method stores a new value to member field of source object](http://fb-contrib.sourceforge.net/bugdescriptions.html#SCA_SUSPICIOUS_CLONE_ALGORITHM)

The clone method stores a value to a member field of the source object. Normally, all
			changes are made to the cloned object, and given that cloning is almost always considered
			a read-only operation, this seems incorrect.