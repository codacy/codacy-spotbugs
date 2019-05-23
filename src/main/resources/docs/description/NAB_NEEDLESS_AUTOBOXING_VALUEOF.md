# [Method passes primitive wrapper to Wrapper class valueOf method](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_AUTOBOXING_VALUEOF)

This method passes a wrapped primitive object to the same class' `valueOf` method.
			Since wrapper classes are immutable, you can just use the original object, rather
			than calling valueOf to create a new one. This code works because of an abuse of autoboxing.