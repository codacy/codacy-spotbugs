# [Static or private method has unused parameters](http://fb-contrib.sourceforge.net/bugdescriptions.html#UP_UNUSED_PARAMETER)

This method defines parameters that are never used. As this method is either static or private,
	       and can't be derived from, it is safe to remove these parameters and simplify your method.
	       You should consider, while unlikely, that this method may be used reflectively, and thus you will
	       want to change that call as well. In this case, it is likely that once you remove the parameter,
	       there will be a chain of method calls that have spent time creating this parameter and passing it
	       down the line. All of this may be able to be removed.