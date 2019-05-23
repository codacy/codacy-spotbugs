# [Method uses reflection to call a method available on java.lang.Object](http://fb-contrib.sourceforge.net/bugdescriptions.html#ROOM_REFLECTION_ON_OBJECT_METHODS)

This method uses reflection to call a method that is defined in java.lang.Object.
			As these methods are always available, it is not necessary to call these methods with
			reflection.