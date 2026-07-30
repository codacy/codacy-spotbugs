# [Method performs math using floating point precision](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FL_MATH_USING_FLOAT_PRECISION)

   The method performs math operations using floating point precision.
   Floating point precision is very imprecise. For example,
   16777216.0f + 1.0f = 16777216.0f. Consider using double math instead.

See [CWE-1339: Insufficient Precision or Accuracy of a Real Number](https://cwe.mitre.org/data/definitions/1339.html).