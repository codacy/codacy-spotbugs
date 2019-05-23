# [Clone method declares it returns a type different than the owning class](http://fb-contrib.sourceforge.net/bugdescriptions.html#CU_CLONE_USABILITY_MISMATCHED_RETURN)

This class implements the Cloneable interface but defines its clone method to return a type
			that is different than the class itself, or any interfaces that the class implements.