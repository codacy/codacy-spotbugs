# [Value that might not carry a type qualifier is always used in a way requires that type qualifier](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TQ_MAYBE_SOURCE_VALUE_REACHES_ALWAYS_SINK)

      A value that is annotated as possibility not being an instance of
    the values denoted by the type qualifier, and the value is guaranteed to be used
    in a way that requires values denoted by that type qualifier.