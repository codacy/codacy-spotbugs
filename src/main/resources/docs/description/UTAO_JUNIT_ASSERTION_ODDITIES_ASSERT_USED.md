# [JUnit test method uses Java asserts rather than a JUnit assertion](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_ASSERT_USED)

This method uses a Java assert to assure that a certain state is in effect. As this is
			a JUnit test it makes more sense to either check this condition with a JUnit assert, or allow
			a following exception to occur.