# [Method attempts to manually schedule threads](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_THREAD_YIELD)

Manual thread scheduling with `Thread.sleep()` or `Thread.yield()` has no guaranteed semantics and is often used to mask race conditions.
			These methods exist for supporting early processors when java was first released, and are not advised for modern processors. The operating system will take care
			of yielding threads for you.