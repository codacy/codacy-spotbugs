# [Method does not check for null argument](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_ARGUMENT_MIGHT_BE_NULL)

    A parameter to this method has been identified as a value that should
    always be checked to see whether or not it is null, but it is being dereferenced
    without a preceding null check.