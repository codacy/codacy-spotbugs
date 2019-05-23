# [Value required to have type qualifier, but marked as unknown](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TQ_EXPLICIT_UNKNOWN_SOURCE_VALUE_REACHES_ALWAYS_SINK)

      A value is used in a way that requires it to be always be a value denoted by a type qualifier, but
    there is an explicit annotation stating that it is not known where the value is required to have that type qualifier.
    Either the usage or the annotation is incorrect.