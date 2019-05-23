# [JUnit test method passes constant to second (actual) assertion parameter](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_ACTUAL_CONSTANT)

This method calls `assertXXX` passing a constant value as the second of the two values. The assert
			methods assume that the expected value is the first parameter, and so it appears that the order
			of values has been swapped here.