# [Method creates Boxed primitive from primitive only to get primitive value](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_BOX_TO_UNBOX)

This method constructs a Boxed Primitive from a primitive only to call the primitiveValue() method to
			convert it back to a primitive. Just use the primitive value instead.

Instead of something like:  

    boolean bo = new Boolean(true).booleanValue();
    float f = new Float(1.234f).floatValue();

			Simply do:   

    boolean bo = true;
    float f = 1.234f;