# [Check for sign of bitwise operation involving negative number](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BIT_SIGNED_CHECK_HIGH_BIT)

 This method compares a bitwise expression such as
`((val & CONSTANT) > 0)` where CONSTANT is the negative number.
Using bit arithmetic and then comparing with the greater than operator can
lead to unexpected results. This comparison is unlikely to work as expected. The good practice is
to use '!= 0' instead of '> 0'.