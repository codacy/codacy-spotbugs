# [Value that might carry a type qualifier is always used in a way prohibits it from having that type qualifier](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TQ_MAYBE_SOURCE_VALUE_REACHES_NEVER_SINK)

      A value that is annotated as possibility being an instance of
    the values denoted by the type qualifier, and the value is guaranteed to be used
    in a way that prohibits values denoted by that type qualifier.