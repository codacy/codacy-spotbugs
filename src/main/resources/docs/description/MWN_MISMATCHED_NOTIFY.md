# [Mismatched notify()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MWN_MISMATCHED_NOTIFY)

 This method calls Object.notify() or Object.notifyAll() without obviously holding a lock
on the object.   Calling notify() or notifyAll() without a lock held will result in
an `IllegalMonitorStateException` being thrown.