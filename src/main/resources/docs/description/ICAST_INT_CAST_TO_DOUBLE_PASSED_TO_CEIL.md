# [Integral value cast to double and then passed to Math.ceil](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ICAST_INT_CAST_TO_DOUBLE_PASSED_TO_CEIL)

This code converts an integral value (e.g., int or long)
to a double precision
floating point number and then
passing the result to the Math.ceil() function, which rounds a double to
the next higher integer value. This operation should always be a no-op,
since converting an integer to a double should give a number with no fractional part.
It is likely that the operation that generated the value to be passed
to Math.ceil was intended to be performed using double precision
floating point arithmetic.