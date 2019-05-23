# [JUnit test method passes null Assert.assertEquals](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_USE_ASSERT_NULL)

This method compares an object's equality to null. It is better to use the Assert.assertNull
			method so that the JUnit failure method is more descriptive of the intended test.