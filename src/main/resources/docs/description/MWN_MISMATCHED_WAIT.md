# [Mismatched wait()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MWN_MISMATCHED_WAIT)

 This method calls Object.wait() without obviously holding a lock
on the object.   Calling wait() without a lock held will result in
an `IllegalMonitorStateException` being thrown.