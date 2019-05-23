# [JUnit test method appears to have no assertions](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_NO_ASSERT)

This JUnit test method has no assertions. While a unit test could still be valid if it relies on whether
			or not an exception is thrown, it is usually a sign of a weak test if there are no assertions. Consider calling
			`fail` after an exception was expected. It is also possible that assertions occur in a called method
			that is not seen by this detector, but this makes the logic of this test more difficult to reason about.