# [TestCase implements a non-static suite method ](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IJU_SUITE_NOT_STATIC)

 Class is a JUnit TestCase and implements the suite() method.
 The suite method should be declared as being static, but isn't.