# [Test for floating point equality](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FE_FLOATING_POINT_EQUALITY)

    This operation compares two floating point values for equality.
    Because floating point calculations may involve rounding,
   calculated float and double values may not be accurate.
    For values that must be precise, such as monetary values,
   consider using a fixed-precision type such as BigDecimal.
    For values that need not be precise, consider comparing for equality
    within some range, for example:
    `if ( Math.abs(x - y) < .0000001 )`.
   See the Java Language Specification, section 4.2.4.