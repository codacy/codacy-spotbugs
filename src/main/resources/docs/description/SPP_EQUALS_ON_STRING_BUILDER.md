# [Method calls equals(Object o) on a StringBuilder or StringBuffer](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_EQUALS_ON_STRING_BUILDER)

This method calls equals on a StringBuilder or StringBuffer. Surprisingly, these classes do not override
			the equals method from Object, and so equals is just defined to be == (or same references). This is most
			likely not what you would like. If you wish to check that the strings have the same characters, you need to
			call toString() on these object and compare them as Strings.