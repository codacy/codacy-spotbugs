# [Method calls Array.asList on an array of primitive values](http://fb-contrib.sourceforge.net/bugdescriptions.html#CAAL_CONFUSING_ARRAY_AS_LIST)

This method passes an array of primitive values to the Arrays.asList call. As primitive
			values in arrays aren't automatically promoted to boxed primitives in arrays, the asList call
			cannot convert this array to a list of boxed primitives. It therefore just creates an array
			with one item in it, the array itself. This is rarely what is desired.