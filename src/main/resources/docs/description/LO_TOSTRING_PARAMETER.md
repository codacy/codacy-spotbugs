# [Method explicitly calls toString() on a logger parameter](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_TOSTRING_PARAMETER)

This method uses parameterized logging to avoid the cost of string concatenation in the case that
			the log level does not meet the needed level. However, one or more of the parameters passed to the logging
			method uses .toString() to present a String representation for the parameter. This is unneeded as the logger
			will do this for you, and because it is explicitly done, will always be called even if the log statement is
			not actually written. Also, by dropping the '.toString()' you may avoid unnecessary NPEs.
			Just pass the variable as a parameter instead.