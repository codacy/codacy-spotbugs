# [Clone method declares it returns an Object](http://fb-contrib.sourceforge.net/bugdescriptions.html#CU_CLONE_USABILITY_OBJECT_RETURN)

This class implements the Cloneable interface but defines its clone method to return an
			Object. Since most likely users of this method will need to cast it to the real type, this will
			be more painful than necessary. Just declare the return value to be the type of this class.