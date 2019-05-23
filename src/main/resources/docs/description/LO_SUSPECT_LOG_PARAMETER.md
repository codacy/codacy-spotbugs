# [Constructor declares a Logger parameter](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_SUSPECT_LOG_PARAMETER)

This constructor declares a parameter that is a Logger. As loggers are meant to be
			created statically per class, it doesn't make sense that you would pass a Logger from one
			class to another. Declare the Logger static in each class instead.