# [Method calls equals on an enum instance](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_EQUALS_ON_ENUM)

This method calls the equals(Object) method on an enum instance. Since enums values are singletons,
			you can use == to safely compare two enum values. In fact, the implementation for Enum.equals does just
			that.