# [Inherited method returns more specific type of object than declared](http://fb-contrib.sourceforge.net/bugdescriptions.html#URV_INHERITED_METHOD_WITH_RELATED_TYPES)

This inherited method is defined to return a java.lang.Object. However, the return types returned
			from this method can be defined by a more specific class or interface. If possible consider changing the
			return type in the inheritance hierarchy of this method, otherwise the caller of this method will be brittle
			in handling of the return type.