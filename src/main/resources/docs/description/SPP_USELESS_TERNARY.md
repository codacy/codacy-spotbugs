# [Method uses a ternary operator to cast a boolean to true or false](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USELESS_TERNARY)

This method tests the value of a boolean and uses a ternary operator to return either true or false.
			The ternary operator is completely unnecessary, just use the original boolean value.