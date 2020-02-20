# [TestCase declares a bad suite method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IJU_BAD_SUITE_METHOD)

 Class is a JUnit TestCase and defines a suite() method.
However, the suite method needs to be declared as either

    public static junit.framework.Test suite()

or

    public static junit.framework.TestSuite suite()