# [Method calls static method on instance reference](http://fb-contrib.sourceforge.net/bugdescriptions.html#SMII_STATIC_METHOD_INSTANCE_INVOCATION)

This method makes a static method call on an instance reference. For
			reading comprehension of the code it is better to call the method on the class,
			rather than an instance. Perhaps this method's static nature has changed since
			this code was written, and should be revisited.