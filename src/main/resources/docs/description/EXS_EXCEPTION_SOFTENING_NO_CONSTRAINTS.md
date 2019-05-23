# [Unconstrained method converts checked exception to unchecked](http://fb-contrib.sourceforge.net/bugdescriptions.html#EXS_EXCEPTION_SOFTENING_NO_CONSTRAINTS)

This method is not constrained by an interface or superclass, but converts a caught checked exception
			to an unchecked exception and throws it. It would be more appropriate just to throw the checked exception,
			adding the exception to the throws clause of the method.