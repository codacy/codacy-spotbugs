# [JUnit test method asserts that an autoboxed value is not null](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_IMPOSSIBLE_NULL)

This method asserts that a primitive value that was autoboxed into a boxed primitive was not
			null. This will never happen, as primitives are never null, and thus the autoboxed value isn't
			either.