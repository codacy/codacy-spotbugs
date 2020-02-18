# [Wait not in loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#WA_NOT_IN_LOOP)

 This method contains a call to `java.lang.Object.wait()`
  which is not in a loop.  If the monitor is used for multiple conditions,
  the condition the caller intended to wait for might not be the one
  that actually occurred.