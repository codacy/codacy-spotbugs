# [Synchronization performed on Lock](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#JLM_JSR166_LOCK_MONITORENTER)

 This method performs synchronization on an object that implements
java.util.concurrent.locks.Lock. Such an object is locked/unlocked
using
`acquire()`/`release()` rather
than using the `synchronized (...)` construct.