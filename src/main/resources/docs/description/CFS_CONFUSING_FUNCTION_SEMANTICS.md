# [Method returns modified parameter](http://fb-contrib.sourceforge.net/bugdescriptions.html#CFS_CONFUSING_FUNCTION_SEMANTICS)

This method appears to modify a parameter, and then return this parameter as the
			method's return value. This will be confusing to callers of this method, as it won't be
			apparent that the 'original' passed-in parameter will be changed as well. If the purpose
			of this method is to change the parameter, it would be more clear to change the method to
			have a void return value. If a return type is required due to interface or superclass contract,
			perhaps a clone of the parameter should be made.