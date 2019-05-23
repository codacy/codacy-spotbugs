# [Method creates array using constants](http://fb-contrib.sourceforge.net/bugdescriptions.html#SACM_STATIC_ARRAY_CREATED_IN_METHOD)

This method creates an array initialized by constants. Each time this method is called
			this array will be recreated. It would be more performant to define the array as a
			static field of the class instead.