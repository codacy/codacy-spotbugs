# [TestNG test method passes boolean expression to Assert.assertFalse / Assert.assertTrue](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_TESTNG_ASSERTION_ODDITIES_USE_ASSERT_NOT_EQUALS)

This method evaluates a boolean expression and passes that to Assert.assertFalse / Assert.assertTrue.
			It is better to pass the two values that are being equated to the Assert.assertNotEquals method so that the
			TestNG failure method is more meaningful of the intended test.