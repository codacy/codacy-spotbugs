# [Negating the result of compareTo()/compare()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_NEGATING_RESULT_OF_COMPARETO)

 This code negatives the return value of a compareTo or compare method.
This is a questionable or bad programming practice, since if the return
value is Integer.MIN_VALUE, negating the return value won't
negate the sign of the result. You can achieve the same intended result
by reversing the order of the operands rather than by negating the results.