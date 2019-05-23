# [TestNG test method passes constant to first (actual) assertion parameter](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_TESTNG_ASSERTION_ODDITIES_ACTUAL_CONSTANT)

This method calls `assertXXX` passing a constant value as the first of the two values. The assert
			method assumes that the expected value is the second parameter, and so it appears that the order
			of values has been swapped here.