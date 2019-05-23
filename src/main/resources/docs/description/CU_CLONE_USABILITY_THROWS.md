# [Clone method declares it throws CloneNotSupportedException](http://fb-contrib.sourceforge.net/bugdescriptions.html#CU_CLONE_USABILITY_THROWS)

This class implements the Cloneable interface but defines its clone method to still throw
			a CloneNotSupportedException. Since you are implementing clone() it would make sense that the method
			in question will _not_ throw that exception, so annotating your method with it just makes clients'
			use of your class more painful as they have to handle an exception that will never happen.
			Just remove the throws clause from your method.