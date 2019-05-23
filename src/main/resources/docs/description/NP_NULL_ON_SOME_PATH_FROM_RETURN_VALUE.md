# [Possible null pointer dereference due to return value of called method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE)

 The return value from a method is dereferenced without a null check,
and the return value of that method is one that should generally be checked
for null.  This may lead to a `NullPointerException` when the code is executed.