# [Method ignores return value, is this OK?](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_RETURN_VALUE_IGNORED_INFERRED)

This code calls a method and ignores the return value. The return value
is the same type as the type the method is invoked on, and from our analysis it looks
like the return value might be important (e.g., like ignoring the
return value of `String.toLowerCase()`).

We are guessing that ignoring the return value might be a bad idea just from
a simple analysis of the body of the method. You can use a @CheckReturnValue annotation
to instruct SpotBugs as to whether ignoring the return value of this method
is important or acceptable.

Please investigate this closely to decide whether it is OK to ignore the return value.