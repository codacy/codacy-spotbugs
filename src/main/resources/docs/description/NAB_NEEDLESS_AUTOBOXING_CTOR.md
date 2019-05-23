# [Method passes primitive wrapper to same primitive wrapper constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_AUTOBOXING_CTOR)

This method passes a wrapped primitive object to the same class's constructor.
			Since wrapper classes are immutable, you can just use the original object, rather
			than constructing a new one. This code works because of an abuse of autoboxing.