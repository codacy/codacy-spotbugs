# [Private or static method only returns one constant value](http://fb-contrib.sourceforge.net/bugdescriptions.html#MRC_METHOD_RETURNS_CONSTANT)

This private or static method only returns one constant value. As this method is private or static,
			its behavior can't be overridden, and thus the return of a constant value seems dubious.
			Either the method should be changed to return no value, or perhaps another return value
			was expected to be returned in another code path in this method.