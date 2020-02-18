# [Condition.await() not in loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#WA_AWAIT_NOT_IN_LOOP)

 This method contains a call to `java.util.concurrent.await()`
   (or variants)
  which is not in a loop.  If the object is used for multiple conditions,
  the condition the caller intended to wait for might not be the one
  that actually occurred.