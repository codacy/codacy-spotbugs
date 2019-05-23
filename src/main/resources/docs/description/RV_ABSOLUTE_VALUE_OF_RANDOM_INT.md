# [Bad attempt to compute absolute value of signed random integer](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT)

 This code generates a random signed integer and then computes
the absolute value of that random integer.  If the number returned by the random number
generator is `Integer.MIN_VALUE`, then the result will be negative as well (since
`Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE`). (Same problem arises for long values as well).