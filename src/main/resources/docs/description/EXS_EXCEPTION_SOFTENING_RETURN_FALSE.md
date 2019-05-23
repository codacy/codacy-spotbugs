# [method converts an exception into a boolean 'error code' value](http://fb-contrib.sourceforge.net/bugdescriptions.html#EXS_EXCEPTION_SOFTENING_RETURN_FALSE)

This method catches an exception and returns a boolean that represents whether an exception occurred or not.
	       This throws away the value of exception handling and lets code ignore the resultant 'error code' return value.
	       You should just throw the exception to the caller instead.