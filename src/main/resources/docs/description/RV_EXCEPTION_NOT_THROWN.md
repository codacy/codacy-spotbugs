# [Exception created and dropped rather than thrown](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_EXCEPTION_NOT_THROWN)

 This code creates an exception (or error) object, but doesn't do anything with it. For example,
something like 

    if (x < 0) {
        new IllegalArgumentException("x must be nonnegative");
    }

It was probably the intent of the programmer to throw the created exception:

    if (x < 0) {
        throw new IllegalArgumentException("x must be nonnegative");
    }