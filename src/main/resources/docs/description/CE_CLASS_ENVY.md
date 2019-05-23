# [Method excessively uses methods of another class](http://fb-contrib.sourceforge.net/bugdescriptions.html#CE_CLASS_ENVY)

This method makes extensive use of methods from another class over methods of its own
			class. Typically this means that the functionality that is accomplished by this method
			most likely belongs with the class that is being used so liberally. Consider refactoring this
			method to be contained in that class, and to accept all the parameters needed in the method signature.