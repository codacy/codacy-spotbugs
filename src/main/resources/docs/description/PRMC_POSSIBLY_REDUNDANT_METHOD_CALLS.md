# [Method appears to call the same method on the same object redundantly](http://fb-contrib.sourceforge.net/bugdescriptions.html#PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS)

This method makes two consecutive calls to the same method, using the same constant
			parameters, on the same instance, without any intervening changes to the objects. If this
			method does not make changes to the object, which it appears it doesn't, then making
			two calls is just a waste. These method calls could be combined by assigning the
			result into a temporary variable, and using the variable the second time.