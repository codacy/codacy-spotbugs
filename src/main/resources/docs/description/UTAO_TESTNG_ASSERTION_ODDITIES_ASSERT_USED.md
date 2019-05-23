# [TestNG test method uses Java asserts rather than a TestNG assertion](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_TESTNG_ASSERTION_ODDITIES_ASSERT_USED)

This method uses a Java assert to assure that a certain state is in effect. As this is
			a TestNG test it makes more sense to either check this condition with a TestNG assert, or allow
			a following exception to occur.