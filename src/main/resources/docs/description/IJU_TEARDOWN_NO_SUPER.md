# [TestCase defines tearDown that doesn't call super.tearDown()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IJU_TEARDOWN_NO_SUPER)

 Class is a JUnit TestCase and implements the tearDown method. The tearDown method should call
super.tearDown(), but doesn't.