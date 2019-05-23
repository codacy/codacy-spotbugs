# [Integer remainder modulo 1](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#INT_BAD_REM_BY_1)

 Any expression (exp % 1) is guaranteed to always return zero.
Did you mean (exp & 1) or (exp % 2) instead?