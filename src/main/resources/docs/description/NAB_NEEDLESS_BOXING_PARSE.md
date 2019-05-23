# [Method converts String to primitive using excessive boxing](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_BOXING_PARSE)

This method passes a String to a wrapped primitive object's valueOf method, which in turn calls
			the boxedValue() method to convert to a primitive. When it is desired to convert from a String
			to a primitive value, it is simpler to use the BoxedPrimitive.parseBoxedPrimitive(String)
			method. 

Instead of something like:  

    public int someMethod(String data) {
    long l = Long.valueOf(data).longValue();
    float f = Float.valueOf(data).floatValue();
    return Integer.valueOf(data); // There is an implicit .intValue() call
    }

			Simply do:   

    public int someMethod(String data) {
    	long l = Long.parseLong(data);
    	float f = Float.parseFloat(data);
    	return Integer.parseInt(data);
    }