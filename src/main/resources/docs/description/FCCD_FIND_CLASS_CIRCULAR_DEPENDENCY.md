# [Class has a circular dependency with other classes](http://fb-contrib.sourceforge.net/bugdescriptions.html#FCCD_FIND_CLASS_CIRCULAR_DEPENDENCY)

		    This class has a circular dependency with other classes. This makes building these classes
		    difficult, as each is dependent on the other to build correctly. Consider using interfaces
		    to break the hard dependency. The dependency chain can be seen in the GUI version of FindBugs.