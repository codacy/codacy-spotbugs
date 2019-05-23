# [Method passes parsed string to primitive wrapper constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_BOXING_STRING_CTOR)

This method passes a primitive value retrieved from a `BoxedPrimitive.parseBoxedPrimitive("1")` call to
			the same class's constructor. It is simpler to just pass the string to the BoxedPrimitive constructor or, better yet, use the static valueOf.

Instead of something like:  

    Boolean bo = new Boolean(Boolean.parseBoolean("true"));
    Float f = new Float(Float.parseFloat("1.234"));

			Simply do:   

    Boolean bo = new Boolean("true");
    Float f = new Float("1.234");

			or, to be more memory efficient:   

    Boolean bo = Boolean.valueOf("true");
    Float f = Float.valueOf("1.234");