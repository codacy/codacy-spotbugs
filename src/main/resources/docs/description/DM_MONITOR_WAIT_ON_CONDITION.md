# [Monitor wait() called on Condition](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_MONITOR_WAIT_ON_CONDITION)

      This method calls `wait()` on a
      `java.util.concurrent.locks.Condition` object. 
      Waiting for a `Condition` should be done using one of the `await()`
      methods defined by the `Condition` interface.