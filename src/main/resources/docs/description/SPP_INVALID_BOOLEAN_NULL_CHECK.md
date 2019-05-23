# [Method uses invalid C++ style null check on Boolean](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_INVALID_BOOLEAN_NULL_CHECK)

This method attempts to check for null by just referring to the variable name
			as would be done in C++. This ordinarily would be considered a compile error, except the
			variable in question is a Boolean, which does an auto unbox to boolean.

    if (b && b.booleanValue())

			should be  

    if (Boolean.TRUE.equals(b))