# [Primitive value is boxed and then immediately unboxed](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BX_BOXING_IMMEDIATELY_UNBOXED)

A primitive is boxed, and then immediately unboxed. This probably is due to a manual
    boxing in a place where an unboxed value is required, thus forcing the compiler
to immediately undo the work of the boxing.