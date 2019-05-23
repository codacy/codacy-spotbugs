# [Method incorrectly passes exception as first argument to logger method](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_LOGGER_LOST_EXCEPTION_STACK_TRACE)

This method passes an exception as the first argument to a logger method. The stack
			trace is potentially lost due to the logger emitting the exception using toString(). It
			is better to construct a log message with sufficient context and pass the exception as
			the second argument to capture the stack trace.