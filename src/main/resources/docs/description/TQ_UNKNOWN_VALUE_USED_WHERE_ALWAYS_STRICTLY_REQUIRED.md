# [Value without a type qualifier used where a value is required to have that qualifier](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TQ_UNKNOWN_VALUE_USED_WHERE_ALWAYS_STRICTLY_REQUIRED)

        A value is being used in a way that requires the value to be annotated with a type qualifier.
    The type qualifier is strict, so the tool rejects any values that do not have
    the appropriate annotation.

        To coerce a value to have a strict annotation, define an identity function where the return value is annotated
    with the strict annotation.
    This is the only way to turn a non-annotated value into a value with a strict type qualifier annotation.