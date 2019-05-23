# [Method retrieves instance to load static member](http://fb-contrib.sourceforge.net/bugdescriptions.html#NIR_NEEDLESS_INSTANCE_RETRIEVAL)

This method calls a method to load a reference to an object, and then only
			uses it to load a static member of that instance's class. It is simpler and
			more performant to just load the static field from the class itself.