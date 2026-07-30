# [Method releases lock without opening it](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CWO_CLOSED_WITHOUT_OPENED)

 This method releases a JSR-166 (`java.util.concurrent`) lock,
        but it is possible that the lock is not even acquired at this point,
        due to an exception thrower method before the locking, moreover even the
        `lock()` function can throw an exception depending on the implementation.
        See the relevant part from the [Javadoc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Lock.html#lock--):
        "A Lock implementation may be able to detect erroneous use of the lock, such as an invocation that would cause deadlock,
        and may throw an (unchecked) exception in such circumstances."

        In general, the correct idiom for using a JSR-166 lock is:

    Lock l = ...;
            l.lock();
            try {
                // do something
            } finally {
                l.unlock();
            }