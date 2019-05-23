# [Constrained method converts checked exception to unchecked instead of another allowable checked exception](http://fb-contrib.sourceforge.net/bugdescriptions.html#EXS_EXCEPTION_SOFTENING_HAS_CHECKED)

This method's exception signature is constrained by an interface of superclass not to throw a
			checked exception that was caught. Therefore this exception was converted to an unchecked exception and
			thrown. It would probably be better to throw the closest checked exception allowed, and to annotate
			the new exception with the original exception using the initial cause field.