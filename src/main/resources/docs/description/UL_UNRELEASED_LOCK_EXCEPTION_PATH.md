# [Method does not release lock on all exception paths](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UL_UNRELEASED_LOCK_EXCEPTION_PATH)

 This method acquires a JSR-166 (`java.util.concurrent`) lock,
but does not release it on all exception paths out of the method.  In general, the correct idiom
for using a JSR-166 lock is:

    Lock l = ...;
    l.lock();
    try {
        // do something
    } finally {
        l.unlock();
    }