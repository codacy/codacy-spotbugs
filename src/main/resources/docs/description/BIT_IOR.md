# [Incompatible bit masks](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BIT_IOR)

 This method compares an expression of the form `(e | C)` to D.
which will always compare unequal
due to the specific values of constants C and D.
This may indicate a logic error or typo.

 Typically, this bug occurs because the code wants to perform
a membership test in a bit set, but uses the bitwise OR
operator ("|") instead of bitwise AND ("&").

Also such bug may appear in expressions like `(e & A | B) == C`
which is parsed like `((e & A) | B) == C` while `(e & (A | B)) == C` was intended.