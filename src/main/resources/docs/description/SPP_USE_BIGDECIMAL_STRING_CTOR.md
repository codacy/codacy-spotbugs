# [Method passes double value to BigDecimal Constructor](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_BIGDECIMAL_STRING_CTOR)

This method calls the BigDecimal constructor that takes a double, and passes a literal double constant value. Since
			the use of BigDecimal is to get better precision than double, by passing a double, you only get the precision of double number
			space. To take advantage of the BigDecimal space, pass the number as a string.