# [Bad attempt to compute absolute value of signed 32-bit hashcode](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_HASHCODE)

 This code generates a hashcode and then computes
the absolute value of that hashcode.  If the hashcode
is `Integer.MIN_VALUE`, then the result will be negative as well (since
`Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE`).

One out of 2^32 strings have a hashCode of Integer.MIN_VALUE,
including "polygenelubricants" "GydZG_" and ""DESIGNING WORKHOUSES".