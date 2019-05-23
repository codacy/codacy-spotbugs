# [Constructor makes call to non-final method](http://fb-contrib.sourceforge.net/bugdescriptions.html#PCOA_PARTIALLY_CONSTRUCTED_OBJECT_ACCESS)

This constructor makes a call to a non-final method. Since this method can be overridden, a subclass'
			implementation will be executing against an object that has not been initialized at the subclass level.
			You should mark all methods called from the constructor as final to avoid this problem.