# [Incorrect combination of Math.max and Math.min](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_INVALID_MIN_MAX)

This code tries to limit the value bounds using the construct like Math.min(0, Math.max(100, value)). However the order of
  the constants is incorrect: it should be Math.min(100, Math.max(0, value)). As the result this code always produces the same result
  (or NaN if the value is NaN).