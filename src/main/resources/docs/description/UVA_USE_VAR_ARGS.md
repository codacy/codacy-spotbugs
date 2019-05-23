# [Method defines parameter list with array as last argument, rather than vararg](http://fb-contrib.sourceforge.net/bugdescriptions.html#UVA_USE_VAR_ARGS)

This method defines a parameter list that ends with an array. As this class is compiled with
			Java 1.5 or better, this parameter could be defined as a vararg parameter instead, which can be
			more convenient for client developers to use. This is not a bug, per se, just an improvement.