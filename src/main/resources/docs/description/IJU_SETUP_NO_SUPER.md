# [TestCase defines setUp that doesn't call super.setUp()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IJU_SETUP_NO_SUPER)

 Class is a JUnit TestCase and implements the setUp method. The setUp method should call
super.setUp(), but doesn't.