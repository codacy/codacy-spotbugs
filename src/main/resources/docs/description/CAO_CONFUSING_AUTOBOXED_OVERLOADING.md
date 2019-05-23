# [Class defines methods which confuse Character with int parameters](http://fb-contrib.sourceforge.net/bugdescriptions.html#CAO_CONFUSING_AUTOBOXED_OVERLOADING)

This class defines two methods that differ only by a parameter being defined
			as Character vs. int, long, float or double. As autoboxing is present, it may be
			assumed that a parameter of 'a' would map to the Character version, but it does not.