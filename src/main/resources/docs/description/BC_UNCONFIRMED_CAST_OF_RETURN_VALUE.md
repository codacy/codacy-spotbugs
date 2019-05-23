# [Unchecked/unconfirmed cast of return value from method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_UNCONFIRMED_CAST_OF_RETURN_VALUE)

This code performs an unchecked cast of the return value of a method.
The code might be calling the method in such a way that the cast is guaranteed to be
safe, but SpotBugs is unable to verify that the cast is safe.  Check that your program logic ensures that this
cast will not fail.