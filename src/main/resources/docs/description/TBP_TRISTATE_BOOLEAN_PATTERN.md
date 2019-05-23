# [Method returns null for Boolean type](http://fb-contrib.sourceforge.net/bugdescriptions.html#TBP_TRISTATE_BOOLEAN_PATTERN)

This method declares that it returns a Boolean value. However, the code
			can return a null value. As this is now three values that can be returned -
			Boolean.TRUE, Boolean.FALSE, null - you have changed what a Boolean means.
			It would be clearer to just create a new Enum that has the three values
			you want, and define that the method returns that type.