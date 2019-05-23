# [A parameter is dead upon entry to a method but overwritten](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IP_PARAMETER_IS_DEAD_BUT_OVERWRITTEN)

The initial value of this parameter is ignored, and the parameter
is overwritten here. This often indicates a mistaken belief that
the write to the parameter will be conveyed back to
the caller.