# [Method uses rt.jar class or method that does not exist](http://fb-contrib.sourceforge.net/bugdescriptions.html#SJVU_SUSPICIOUS_JDK_VERSION_USE)

This method calls a method that does not exist, on a class that does not exist in the JDK that
			this class has been compiled for. This can happen if you compile the class specifying the -source and
			-target options, and use a version that is before the version of the compiler's JDK.