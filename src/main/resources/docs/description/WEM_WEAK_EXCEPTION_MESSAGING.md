# [Method throws exception with static message string](http://fb-contrib.sourceforge.net/bugdescriptions.html#WEM_WEAK_EXCEPTION_MESSAGING)

This method creates and throws an exception using a static string as the exceptions message.
			Without any specific context of this particular exception invocation, such as the values of parameters,
			key member variables, or local variables, it may be difficult to infer how this exception occurred. Consider
			adding context to the exception message.