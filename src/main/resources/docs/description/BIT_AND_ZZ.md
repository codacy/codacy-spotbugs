# [Check to see if ((...) & 0) == 0](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BIT_AND_ZZ)

 This method compares an expression of the form `(e & 0)` to 0,
which will always compare equal.
This may indicate a logic error or typo.