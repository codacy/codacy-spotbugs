# [Empty method could be declared abstract](http://fb-contrib.sourceforge.net/bugdescriptions.html#ACEM_ABSTRACT_CLASS_EMPTY_METHODS)

This method is empty or merely throws an exception. Since the class it is defined in is
			abstract, it may be more correct to define this method as abstract instead, so that proper
			subclass behavior is enforced.