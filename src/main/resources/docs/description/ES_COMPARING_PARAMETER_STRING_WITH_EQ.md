# [Comparison of String parameter using == or !=](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ES_COMPARING_PARAMETER_STRING_WITH_EQ)

This code compares a `java.lang.String` parameter for reference
equality using the == or != operators. Requiring callers to
pass only String constants or interned strings to a method is unnecessarily
fragile, and rarely leads to measurable performance gains. Consider
using the `equals(Object)` method instead.