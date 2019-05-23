# [Parameter must be non-null but is marked as nullable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE)

 This parameter is always used in a way that requires it to be non-null,
but the parameter is explicitly annotated as being Nullable. Either the use
of the parameter or the annotation is wrong.