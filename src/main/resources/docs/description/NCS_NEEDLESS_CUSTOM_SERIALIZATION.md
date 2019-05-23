# [Method needlessly implements what is default streaming behavior](http://fb-contrib.sourceforge.net/bugdescriptions.html#NCS_NEEDLESS_CUSTOM_SERIALIZATION)

This method implements the Serializable interface by performing the same operations that
			would be done if this method did not exist. Since this is the case, this method is not needed.