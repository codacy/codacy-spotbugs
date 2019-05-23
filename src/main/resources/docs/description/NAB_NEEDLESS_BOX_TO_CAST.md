# [Method creates Boxed primitive from primitive only to cast to another primitive type](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_BOX_TO_CAST)

This method constructs a Boxed Primitive from a primitive only to call the primitiveValue() method to
			cast the value to another primitive type. It is simpler to just use casting.

Instead of something like:  

    double someDouble = ...
    float f = new Double(someDouble).floatValue();

    int someInt = ...
    byte b = new Integer(someInt).byteValue();

			Simply do:   

    double someDouble = ...
    float f = (float) someDouble;

    int someInt = ...
    byte b = (byte)someInt;