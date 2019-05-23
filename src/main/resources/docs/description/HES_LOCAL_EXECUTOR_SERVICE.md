# [Suspicious Local Executor Service](http://fb-contrib.sourceforge.net/bugdescriptions.html#HES_LOCAL_EXECUTOR_SERVICE)

`ExecutorService`s are typically instantiated as fields so that many tasks can be executed on a controlled number of `Thread`s across many method calls.  Therefore, it is unusual for `ExecutorService`s to be a local variable, where tasks will be added only one time, in the enclosing method. 

Furthermore, when a local `ExecutorService` reaches the end of scope and goes up for garbage collection, the internal `Thread`s are not necessarily terminated and can prevent the JVM from ever shutting down.

Consider making this local variable a field and creating a method that will explicitly shut down the `ExecutorService`