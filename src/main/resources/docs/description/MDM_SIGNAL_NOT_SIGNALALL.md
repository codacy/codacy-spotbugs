# [Method calls Condition.signal() rather than Condition.signalAll()](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_SIGNAL_NOT_SIGNALALL)

`Condition.signalAll()` is preferred over `Condition.signal()`. Calling `signal()` only wakes up one thread, meaning that the thread woken up might not be the one waiting for the condition that the caller just satisfied.