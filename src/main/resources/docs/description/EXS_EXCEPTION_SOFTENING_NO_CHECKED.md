# [Constrained method converts checked exception to unchecked](http://fb-contrib.sourceforge.net/bugdescriptions.html#EXS_EXCEPTION_SOFTENING_NO_CHECKED)

This method's exception signature is constrained by an interface or superclass not to throw
			any checked exceptions. Therefore a caught checked exception was converted to an unchecked exception
			and thrown. However, it appears that the class in question is owned by the same author as the constraining
			interface or superclass. Consider changing the signature of this method to include the checked exception.