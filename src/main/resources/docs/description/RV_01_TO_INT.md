# [Random value from 0 to 1 is coerced to the integer 0](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_01_TO_INT)

A random value from 0 to 1 is being coerced to the integer value 0\. You probably
want to multiply the random value by something else before coercing it to an integer, or use the `Random.nextInt(n)` method.