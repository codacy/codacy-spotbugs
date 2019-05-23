# [Method stutters exception message in logger](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_STUTTERED_MESSAGE)

This method uses a logger method that takes an exception, and passes the result of
			the exception's getMessage() method as the log message.
			Since you are already passing in the exception, that message is already present in the
			logs, and by passing it in as the message, you are just stuttering information.
			It would be more helpful to provide a handwritten message that describes the error in
			this method, possibly including the values of key variables.