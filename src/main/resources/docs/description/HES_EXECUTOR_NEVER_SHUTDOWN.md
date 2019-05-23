# [ExecutorService field doesn't ever get shutdown](http://fb-contrib.sourceforge.net/bugdescriptions.html#HES_EXECUTOR_NEVER_SHUTDOWN)

Most `ExecutorService` objects must be explicitly shut down,
            otherwise their internal threads can prolong the running of the JVM, even when everything
            else has stopped.

FindBugs has detected that there are no calls to either the `shutdown()` or `shutdownNow()`
            method, and thus, the `ExecutorService` is not guaranteed to ever terminate.  This is especially
            problematic for `Executors.newFixedThreadPool()` and most of the other convenience methods in
            the `Executors` class.

Even though there are some exceptions to this, particularly when a custom `ThreadFactory` is
			provided, or for `ThreadPoolExecutor`s with `allowsCoreThreadTimeOut()` set to true,
			it is good practice to explicitly shutdown the `ExecutorService` when its utility is done.