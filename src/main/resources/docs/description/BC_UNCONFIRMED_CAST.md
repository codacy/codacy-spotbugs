# [Unchecked/unconfirmed cast](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_UNCONFIRMED_CAST)

This cast is unchecked, and not all instances of the type cast from can be cast to
the type it is being cast to. Check that your program logic ensures that this
cast will not fail.