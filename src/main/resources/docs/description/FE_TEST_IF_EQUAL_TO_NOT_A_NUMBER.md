# [Doomed test for equality to NaN](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FE_TEST_IF_EQUAL_TO_NOT_A_NUMBER)

    This code checks to see if a floating point value is equal to the special
    Not A Number value (e.g., `if (x == Double.NaN)`). However,
    because of the special semantics of `NaN`, no value
    is equal to `Nan`, including `NaN`. Thus,
    `x == Double.NaN` always evaluates to false.

    To check to see if a value contained in `x`
    is the special Not A Number value, use
    `Double.isNaN(x)` (or `Float.isNaN(x)` if
    `x` is floating point precision).