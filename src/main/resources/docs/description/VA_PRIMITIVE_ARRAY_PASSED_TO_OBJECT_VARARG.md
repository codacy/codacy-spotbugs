# [Primitive array passed to function expecting a variable number of object arguments](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#VA_PRIMITIVE_ARRAY_PASSED_TO_OBJECT_VARARG)

This code passes a primitive array to a function that takes a variable number of object arguments.
This creates an array of length one to hold the primitive array and passes it to the function.