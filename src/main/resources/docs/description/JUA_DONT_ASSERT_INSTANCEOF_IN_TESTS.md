# [ Asserting value of instanceof in tests is not recommended. ](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#JUA_DONT_ASSERT_INSTANCEOF_IN_TESTS)

Asserting type checks in tests is not recommended as a class cast exception message could better indicate
            the cause of an instance of the wrong class being used than an instanceof assertion.

When debugging tests that fail due to bad casts, it may be more useful to observe the output of the
            resulting ClassCastException which could provide information about the actual encountered type.
            Asserting the type before casting would instead result in a less informative `"false is not true"`
            message.

If JUnit is used with hamcrest, the [`IsInstanceOf`](https://junit.org/junit4/javadoc/latest/index.html?org/hamcrest/core/IsInstanceOf.html)
            class from hamcrest could be used instead.