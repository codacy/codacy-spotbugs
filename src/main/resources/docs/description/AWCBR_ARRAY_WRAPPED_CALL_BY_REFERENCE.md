# [Method uses 1 element array to simulate call by reference](http://fb-contrib.sourceforge.net/bugdescriptions.html#AWCBR_ARRAY_WRAPPED_CALL_BY_REFERENCE)

This method uses a one-element array to wrap an object that is to be passed to a method as an argument
			to simulate call by pointer ala C++. It is better to define a proper return class type that holds all
			the relevant information retrieved from the called method.