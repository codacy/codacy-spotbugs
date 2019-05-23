# [Method serializes an instance of a non-static inner class](http://fb-contrib.sourceforge.net/bugdescriptions.html#PUS_POSSIBLE_UNSUSPECTED_SERIALIZATION)

This method serializes an instance of a non-static inner class. Since this class has a
			reference to the containing class, this outer class will be serialized as well. This is often
			not intentional, and will make the amount of data that is serialized much more than is needed.
			If the outer class is not desired to be serialized, either make the inner class static, or
			pull it out into a separate "first class" class.