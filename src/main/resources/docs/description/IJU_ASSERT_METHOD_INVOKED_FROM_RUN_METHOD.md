# [JUnit assertion in run method will not be noticed by JUnit](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IJU_ASSERT_METHOD_INVOKED_FROM_RUN_METHOD)

 A JUnit assertion is performed in a run method. Failed JUnit assertions
just result in exceptions being thrown.
Thus, if this exception occurs in a thread other than the thread that invokes
the test method, the exception will terminate the thread but not result
in the test failing.