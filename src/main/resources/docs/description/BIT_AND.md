# [Incompatible bit masks](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BIT_AND)

 This method compares an expression of the form (e & C) to D,
which will always compare unequal
due to the specific values of constants C and D.
This may indicate a logic error or typo.