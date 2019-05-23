# [Method converts a String literal](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_CONVERSION_OF_STRING_LITERAL)

This method calls a converting method like `toLowerCase` or `trim`
		   on a `String` literal. You should make the transformation yourself and use the transformed literal.

		   For example, instead of :  

    return "ThisIsAConstantString".toLowerCase().trim();

		   just do   

    return "thisisaconstantstring";

		   for shorter and easier to read code.  An exception might be made when locale-specific transformations need
		   to be done (in the case of `toUpperCase()` and `toLowerCase()`.