# [JUnit test method asserts that two doubles are exactly equal](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTAO_JUNIT_ASSERTION_ODDITIES_INEXACT_DOUBLE)

This method calls `assertXXX` with two doubles or Doubles. Due to the imprecision of doubles, you
			should be using the assert method that takes a range parameter that gives a range of error.