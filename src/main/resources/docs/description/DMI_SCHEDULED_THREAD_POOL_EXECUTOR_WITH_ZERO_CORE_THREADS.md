# [Creation of ScheduledThreadPoolExecutor with zero core threads](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_SCHEDULED_THREAD_POOL_EXECUTOR_WITH_ZERO_CORE_THREADS)

([Javadoc](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledThreadPoolExecutor.html#ScheduledThreadPoolExecutor%28int%29))
A ScheduledThreadPoolExecutor with zero core threads will never execute anything; changes to the max pool size are ignored.