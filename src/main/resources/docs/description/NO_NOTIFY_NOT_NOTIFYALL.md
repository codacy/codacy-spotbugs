# [Using notify() rather than notifyAll()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NO_NOTIFY_NOT_NOTIFYALL)

 This method calls `notify()` rather than `notifyAll()`. 
  Java monitors are often used for multiple conditions.  Calling `notify()`
  only wakes up one thread, meaning that the thread woken up might not be the
  one waiting for the condition that the caller just satisfied.