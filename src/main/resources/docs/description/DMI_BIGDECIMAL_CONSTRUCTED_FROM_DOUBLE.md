# [BigDecimal constructed from double that isn't represented precisely](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_BIGDECIMAL_CONSTRUCTED_FROM_DOUBLE)

This code creates a BigDecimal from a double value that doesn't translate well to a
decimal number.
For example, one might assume that writing new BigDecimal(0.1) in Java creates a BigDecimal which is exactly equal to 0.1 (an unscaled value of 1, with a scale of 1), but it is actually equal to 0.1000000000000000055511151231257827021181583404541015625.
You probably want to use the BigDecimal.valueOf(double d) method, which uses the String representation
of the double to create the BigDecimal (e.g., BigDecimal.valueOf(0.1) gives 0.1).