# [Inefficient use of String.lastIndexOf(String)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IIO_INEFFICIENT_LAST_INDEX_OF)

 This code passes a constant string of length 1 to String.lastIndexOf().
It is more efficient to use the integer implementations of String.lastIndexOf().
f. e. call `myString.lastIndexOf('.')` instead of `myString.lastIndexOf(".")`