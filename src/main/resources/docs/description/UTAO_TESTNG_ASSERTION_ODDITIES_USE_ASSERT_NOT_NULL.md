# [TestNG test method passes null Assert.assertNotEquals](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_TESTNG_ASSERTION_ODDITIES_USE_ASSERT_NOT_NULL)

This method compares an object's inequality to null. It is better to use the Assert.assertNotNull
			method so that the TestNG failure method is more descriptive of the intended test.