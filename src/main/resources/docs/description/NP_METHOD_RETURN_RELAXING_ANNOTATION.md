# [Method relaxes nullness annotation on return value](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_METHOD_RETURN_RELAXING_ANNOTATION)

        A method should always implement the contract of a method it overrides. Thus, if a method takes is annotated
    as returning a @Nonnull value,
    you shouldn't override that method in a subclass with a method annotated as returning a @Nullable or @CheckForNull value.
    Doing so violates the contract that the method shouldn't return null.