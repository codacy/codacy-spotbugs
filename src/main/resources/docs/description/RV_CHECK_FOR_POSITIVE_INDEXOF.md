# [Method checks to see if result of String.indexOf is positive](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RV_CHECK_FOR_POSITIVE_INDEXOF)

 The method invokes String.indexOf and checks to see if the result is positive or non-positive.
   It is much more typical to check to see if the result is negative or non-negative. It is
   positive only if the substring checked for occurs at some place other than at the beginning of
   the String.