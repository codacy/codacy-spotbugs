# [Remainder of hashCode could be negative](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_REM_OF_HASHCODE)

 This code computes a hashCode, and then computes
the remainder of that value modulo another value. Since the hashCode
can be negative, the result of the remainder operation
can also be negative. 

 Assuming you want to ensure that the result of your computation is nonnegative,
you may need to change your code.
If you know the divisor is a power of 2,
you can use a bitwise and operator instead (i.e., instead of
using `x.hashCode()%n`, use `x.hashCode()&(n-1)`).
This is probably faster than computing the remainder as well.
If you don't know that the divisor is a power of 2, take the absolute
value of the result of the remainder operation (i.e., use
`Math.abs(x.hashCode()%n)`).