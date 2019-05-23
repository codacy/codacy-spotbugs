# [Non-null field is not initialized](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NONNULL_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR)

 The field is marked as non-null, but isn't written to by the constructor.
    The field might be initialized elsewhere during constructor, or might always
    be initialized before use.