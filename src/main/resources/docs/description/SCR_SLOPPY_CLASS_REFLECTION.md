# [Method accesses statically bound class with Class.forName](http://fb-contrib.sourceforge.net/bugdescriptions.html#SCR_SLOPPY_CLASS_REFLECTION)

This method accesses the class object of a class that is already statically bound
			in this context, with Class.forName. Using Class.forName makes reflection more fragile
			in regards to code transformations such as obfuscation, and is unneeded here, since
			the class in question is already 'linked' to this class.