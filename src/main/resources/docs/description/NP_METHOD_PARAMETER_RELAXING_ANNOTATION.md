# [Method tightens nullness annotation on parameter](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_METHOD_PARAMETER_RELAXING_ANNOTATION)

        A method should always implement the contract of a method it overrides. Thus, if a method takes a parameter
    that is marked as @Nullable, you shouldn't override that method in a subclass with a method where that parameter is @Nonnull.
    Doing so violates the contract that the method should handle a null parameter.