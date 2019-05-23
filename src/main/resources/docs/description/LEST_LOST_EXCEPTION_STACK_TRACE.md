# [Method throws alternative exception from catch block without history](http://fb-contrib.sourceforge.net/bugdescriptions.html#LEST_LOST_EXCEPTION_STACK_TRACE)

This method catches an exception, and throws a different exception, without incorporating the
			original exception. Doing so hides the original source of the exception, making debugging and fixing
			these problems difficult. It is better to use the constructor of this new exception that takes an
			original exception so that this detail can be passed along to the user. If this exception has no constructor
			that takes an initial cause parameter, use the initCause method to initialize it instead.

    catch (IOException e) {
        throw new MySpecialException("Failed to open configuration", e);
    }