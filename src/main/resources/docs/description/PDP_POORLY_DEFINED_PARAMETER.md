# [Method defines parameters more abstractly than needed to function properly](http://fb-contrib.sourceforge.net/bugdescriptions.html#PDP_POORLY_DEFINED_PARAMETER)

This method defines parameters at a more abstract level than is actually needed to function correctly,
			as the code casts these parameters to more concrete types. Since this method is not derivable, you should
			just define the parameters with the type that is needed.