# [Class defines fields that are used only as locals](http://fb-contrib.sourceforge.net/bugdescriptions.html#FCBL_FIELD_COULD_BE_LOCAL)

This class defines fields that are used in a local only fashion,
			specifically private fields or protected fields in final classes that are accessed
			first in each method with a store vs. a load. This field could be replaced by one
			or more local variables.