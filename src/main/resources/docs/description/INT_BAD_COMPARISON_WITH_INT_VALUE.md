# [Bad comparison of int value with long constant](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#INT_BAD_COMPARISON_WITH_INT_VALUE)

 This code compares an int value with a long constant that is outside
the range of values that can be represented as an int value.
This comparison is vacuous and possibly incorrect.