# [Method calls a method from a class that has been shaded by a 3rdparty jar](http://fb-contrib.sourceforge.net/bugdescriptions.html#SSCU_SUSPICIOUS_SHADED_CLASS_USE)

This method calls a method found in a 3rd-party library, which appears to be shaded from another 3rd-party library.
    		This occurs when a jar includes other code that uses tools like the maven shade plugin. It is likely you wanted to use the
    		"first-class" class from the original jar, rather than the class with the shaded package structure, but your IDE pulled in
    		the wrong import.

An example might be, you attempted to use a method from the class:

    com.google.common.collect.Sets

    		But instead, you import:

    org.apache.jena.ext.com.google.common.collect.Sets