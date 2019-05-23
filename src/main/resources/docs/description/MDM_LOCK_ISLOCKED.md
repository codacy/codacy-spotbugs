# [Method tests if a lock is locked](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_LOCK_ISLOCKED)

Calling `ReentrantLock.isLocked()` or `ReentrantLock.isHeldByCurrentThread()` might indicate race conditions or incorrect locking. These methods are designed for use in debug code or monitoring of the system state, not for synchronization control.