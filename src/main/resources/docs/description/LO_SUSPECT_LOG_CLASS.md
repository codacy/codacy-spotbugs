# [Method specifies an unrelated class when allocating a Logger](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_SUSPECT_LOG_CLASS)

This method creates a Logger by passing in a specification for a class that is unrelated
			to the class in which the logger is going to be used. This is likely caused by copy/paste code.