# [Method calls toString() on an instance of a class that hasn't overridden toString()](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_NON_USEFUL_TOSTRING)

This method calls `toString` on an object that hasn't overridden the toString() method, and thus relies on
	       the version found in java.lang.Object. This string is just a raw display of the object's class and location, and
	       provides no information about the information of use. You should implement toString in this class.