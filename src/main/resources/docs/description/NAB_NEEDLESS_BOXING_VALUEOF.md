# [Method converts String to boxed primitive using excessive boxing](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_BOXING_VALUEOF)

This method passes a String to a wrapped primitive object's parse method, which in turn calls
			the `valueOf` method to convert to a boxed primitive. When it is desired to convert from a String
			to a boxed primitive object, it is simpler to use the BoxedPrimitive.valueOf(String) method.

Instead of something like:  

    Boolean bo = Boolean.valueOf(Boolean.parseBoolean("true"));
    Float f = Float.valueOf(Float.parseFloat("1.234"));

			Simply do:   

    Boolean bo = Boolean.valueOf("true");
    Float f = Float.valueOf("1.234");