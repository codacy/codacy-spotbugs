# [An ExecutorService isn't shutdown before the reference to it is lost](http://fb-contrib.sourceforge.net/bugdescriptions.html#HES_EXECUTOR_OVERWRITTEN_WITHOUT_SHUTDOWN)

Most `ExecutorService` objects must be explicitly shut down, otherwise their internal threads
            can prevent the JVM from ever shutting down, even when everything else has stopped.

FindBugs has detected that something like the following is happening:  

    ExecutorService executor = ... //e.g. Executors.newCachedThreadPool();
    ...
    public void reset() {
        this.executor = Executors.newCachedThreadPool();
        this.executor.execute(new SampleExecutable());
    }

            For normal objects, losing the last reference to them like this would trigger the object to be cleaned up
            in garbage collection.  For `ExecutorService`s, this isn't enough to terminate the internal threads in the
            thread pool, and the `ExecutorService` isn't guaranteed to shut down, causing the JVM to never stop.   

            To fix this, simply add a call to `shutdown()` like this:  

    ExecutorService executor = ... //e.g. Executors.newCachedThreadPool();
    ...
    public void reset() {
        this.executor.shutDown(); //Fix
        this.executor = Executors.newCachedThreadPool();
        this.executor.execute(new SampleExecutable());
    }

Even though there are some exceptions to this, particularly when a custom `ThreadFactory` is
			provided, or for `ThreadPoolExecutor`s with `allowsCoreThreadTimeOut()` set to true,
			it is good practice to explicitly shut down the `ExecutorService` at the end of execution, or
			when it is being replaced.

**Note:** `ExecutorService`s are generally created once in a program's life cycle.  If you find yourself
			replacing the `ExecutorService`, perhaps you may consider restructuring your code to use calls like
			`awaitTermination()` or `Future`s/`Callable`s to avoid recreating the `ExecutorService`.