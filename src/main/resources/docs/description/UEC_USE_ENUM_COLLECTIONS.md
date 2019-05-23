# [Class uses an ordinary set or map with an enum class as the key](http://fb-contrib.sourceforge.net/bugdescriptions.html#UEC_USE_ENUM_COLLECTIONS)

This class uses an ordinary set or map collection and uses an enum class as the key type.
			It is more performant to use the JDK 1.5 EnumSet or EnumMap classes.