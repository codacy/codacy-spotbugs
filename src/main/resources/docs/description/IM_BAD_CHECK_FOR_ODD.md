# [Check for oddness that won't work for negative numbers](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IM_BAD_CHECK_FOR_ODD)

The code uses x % 2 == 1 to check to see if a value is odd, but this won't work
for negative numbers (e.g., (-5) % 2 == -1). If this code is intending to check
for oddness, consider using (x & 1) == 1, or x % 2 != 0.