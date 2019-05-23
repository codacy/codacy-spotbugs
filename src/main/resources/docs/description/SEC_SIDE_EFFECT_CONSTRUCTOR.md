# [Method uses a Side Effect Constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#SEC_SIDE_EFFECT_CONSTRUCTOR)

This method creates an object but does not assign this object to any variable or field.
			This implies that the class operates through side effects in the constructor, which is a
			bad pattern to use, as it adds unnecessary coupling. Consider pulling the side effect out of
			the constructor, into a separate method, or into the calling method.