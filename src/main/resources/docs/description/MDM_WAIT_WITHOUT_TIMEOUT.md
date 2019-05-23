# [Method sleeps without timeout](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_WAIT_WITHOUT_TIMEOUT)

Calling one of the following methods without timeout could block forever. Consider using a timeout to detect deadlocks or performance problems.
			Methods:

*   Thread.join()
*   Object.wait()
*   Condition.await()
*   Lock.lock()
*   Lock.lockInterruptibly()
*   ReentrantLock.lock()
*   ReentrantLock.lockInterruptibly()