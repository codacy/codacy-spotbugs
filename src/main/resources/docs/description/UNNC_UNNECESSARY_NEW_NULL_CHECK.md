# [Method checks the result of a new allocation](http://fb-contrib.sourceforge.net/bugdescriptions.html#UNNC_UNNECESSARY_NEW_NULL_CHECK)

This method allocates an object with `new`, and then checks that the object is null
			or non null. As the new operator is guaranteed to either succeed or throw an exception,
			this null check is unnecessary and can be removed.