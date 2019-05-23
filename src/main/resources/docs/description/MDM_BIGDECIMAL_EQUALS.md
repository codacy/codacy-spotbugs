# [Method calls BigDecimal.equals()](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_BIGDECIMAL_EQUALS)

This method calls `equals()` to compare two `java.math.BigDecimal` numbers.
			This is normally a mistake, as two `BigDecimal` objects are only equal if they are
			equal in both value and scale, so that _2.0_ is not equal to _2.00_.
			To compare `BigDecimal` objects for mathematical equality, use `compareTo()` instead.