# [Method compares class name instead of comparing class](http://fb-contrib.sourceforge.net/bugdescriptions.html#CCNE_COMPARE_CLASS_EQUALS_NAME)

In a JVM, two classes are the same class (and consequently the same type) if
			they are loaded by the same class loader, and they have the same fully
			qualified name [JVMSpec 1999].

			Comparing class name ignores the class loader.