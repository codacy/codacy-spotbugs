# [Unconditional wait](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UW_UNCOND_WAIT)

 This method contains a call to `java.lang.Object.wait()` which
    is not guarded by conditional control flow. The code should
    verify that condition it intends to wait for is not already satisfied
    before calling wait; any previous notifications will be ignored.