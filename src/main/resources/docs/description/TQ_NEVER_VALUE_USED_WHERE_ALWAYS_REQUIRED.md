# [Value annotated as never carrying a type qualifier used where value carrying that qualifier is required](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TQ_NEVER_VALUE_USED_WHERE_ALWAYS_REQUIRED)

        A value specified as not carrying a type qualifier annotation is guaranteed
        to be consumed in a location or locations requiring that the value does
        carry that annotation.

        More precisely, a value annotated with a type qualifier specifying when=NEVER
        is guaranteed to reach a use or uses where the same type qualifier specifies when=ALWAYS.

        TODO: example