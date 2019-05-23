# [JUnit test method passes boolean expression to Assert.assertFalse / Assert.assertTrue](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_USE_ASSERT_EQUALS)

This method evaluates a boolean expression and passes that to Assert.assertFalse / Assert.assertTrue.
			It is better to pass the two values that are being equated to the Assert.assertEquals method so that the
			JUnit failure method is more descriptive of the intended test.