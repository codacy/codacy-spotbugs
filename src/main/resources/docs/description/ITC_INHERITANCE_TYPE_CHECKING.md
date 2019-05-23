# [Method uses instanceof on multiple types to arbitrate logic](http://fb-contrib.sourceforge.net/bugdescriptions.html#ITC_INHERITANCE_TYPE_CHECKING)

This method uses the instanceof operator in a series of if/else statements to
			differentiate blocks of code based on type. If these types are related by inheritance,
			it is cleaner to just define a method in the base class, and use overridden methods
			in these classes.