# [Inefficient use of String.indexOf(String)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IIO_INEFFICIENT_INDEX_OF)

 This code passes a constant string of length 1 to String.indexOf().
It is more efficient to use the integer implementations of String.indexOf().
f. e. call `myString.indexOf('.')` instead of `myString.indexOf(".")`