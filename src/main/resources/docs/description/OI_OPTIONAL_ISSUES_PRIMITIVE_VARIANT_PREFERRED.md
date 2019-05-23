# [Method uses a java.util.Optional when use of OptionalInt, OptionalLong, OptionalDouble would be more clear](http://fb-contrib.sourceforge.net/bugdescriptions.html#OI_OPTIONAL_ISSUES_PRIMITIVE_VARIANT_PREFERRED)

This method creates an Optional object to hold an int, double or long. In these cases it
    		is more natural to use the Optional variants OptionalInt, OptionalDouble and OptionalLong.