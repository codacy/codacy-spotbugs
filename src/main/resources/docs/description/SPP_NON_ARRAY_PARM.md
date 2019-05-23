# [Method passes a non array object to a parameter that expects an array](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_NON_ARRAY_PARM)

This method expects an array to be passed as one of its parameters, but unfortunately defines
			the parameter as Object. This invocation of this method does not pass an array and will throw
			an exception when run.