# [Remainder of 32-bit signed random integer](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_REM_OF_RANDOM_INT)

 This code generates a random signed integer and then computes
the remainder of that value modulo another value. Since the random
number can be negative, the result of the remainder operation
can also be negative. Be sure this is intended, and strongly
consider using the Random.nextInt(int) method instead.