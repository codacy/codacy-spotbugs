# [Comparing values with incompatible type qualifiers](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TQ_COMPARING_VALUES_WITH_INCOMPATIBLE_TYPE_QUALIFIERS)

        A value specified as carrying a type qualifier annotation is
        compared with a value that doesn't ever carry that qualifier.

        More precisely, a value annotated with a type qualifier specifying when=ALWAYS
        is compared with a value that where the same type qualifier specifies when=NEVER.

        For example, say that @NonNegative is a nickname for
        the type qualifier annotation @Negative(when=When.NEVER).
        The following code will generate this warning because
        the return statement requires a @NonNegative value,
        but receives one that is marked as @Negative.

    public boolean example(@Negative Integer value1, @NonNegative Integer value2) {
        return value1.equals(value2);
    }