# [Return value of method without side effect is ignored](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT)

This code calls a method and ignores the return value. However, our analysis shows that
the method (including its implementations in subclasses if any) does not produce any effect
other than return value. Thus, this call can be removed.

We are trying to reduce the false positives as much as possible, but in some cases this warning might be wrong.
Common false-positive cases include:

- The method is designed to be overridden and produce a side effect in other projects which are out of the scope of the analysis.

- The method is called to trigger the class loading which may have a side effect.

- The method is called just to get some exception.

If you feel that our assumption is incorrect, you can use a @CheckReturnValue annotation
to instruct SpotBugs that ignoring the return value of this method is acceptable.