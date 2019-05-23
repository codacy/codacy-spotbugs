# [int value cast to float and then passed to Math.round](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ICAST_INT_CAST_TO_FLOAT_PASSED_TO_ROUND)

This code converts an int value to a float precision
floating point number and then
passing the result to the Math.round() function, which returns the int/long closest
to the argument. This operation should always be a no-op,
since the converting an integer to a float should give a number with no fractional part.
It is likely that the operation that generated the value to be passed
to Math.round was intended to be performed using
floating point arithmetic.