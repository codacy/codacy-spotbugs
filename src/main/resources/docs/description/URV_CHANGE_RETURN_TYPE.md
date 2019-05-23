# [Method returns more specific type of object than declared](http://fb-contrib.sourceforge.net/bugdescriptions.html#URV_CHANGE_RETURN_TYPE)

This method is defined to return a java.lang.Object. However, the return types
			returned from this method can be defined by a more specific class or interface. Since this
			method is not derived from a superclass or interface, it would be more clear to
			change the return type of this method.