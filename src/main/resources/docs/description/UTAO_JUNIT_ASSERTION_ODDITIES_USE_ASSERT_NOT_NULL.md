# [JUnit test method passes null Assert.assertNotEquals](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_USE_ASSERT_NOT_NULL)

This method compares an object's inequality to null. It is better to use the Assert.assertNotNull
			method so that the JUnit failure method is more descriptive of the intended test.