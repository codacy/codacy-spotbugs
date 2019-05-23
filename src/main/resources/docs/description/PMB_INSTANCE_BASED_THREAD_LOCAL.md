# [Field is an instance based ThreadLocal variable](http://fb-contrib.sourceforge.net/bugdescriptions.html#PMB_INSTANCE_BASED_THREAD_LOCAL)

This ThreadLocal field is defined as being instance based (not static). As all
	       ThreadLocal variables describe permanent reachability roots so far as the garbage
	       collector is concerned, these variables will never be reclaimed (so long as the Thread lives).
	       Since this ThreadLocal is instanced, you potentially will be creating many non-reclaimable
	       variables, even after the owning instance has been reclaimed. It is almost a certainty that
	       you want to use static based ThreadLocal variables.