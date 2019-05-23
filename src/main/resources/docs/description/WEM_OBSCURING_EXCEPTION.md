# [Method throws a java.lang.Exception that wraps a more useful exception](http://fb-contrib.sourceforge.net/bugdescriptions.html#WEM_OBSCURING_EXCEPTION)

This method catches an exception and generates a new exception of type java.lang.Exception,
			passing the original exception as the new Exception's cause.  If the original Exception was actually
			a java.lang.Error, this is dubious as you should not be handling errors. If the original exception
			is a more specific exception, there is no reason to wrap it in a java.lang.Exception;
			this just obfuscates the type of error that is occurring.