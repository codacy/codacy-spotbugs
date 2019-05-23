# [Class defines a serialVersionUID as non private](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_SERIALVER_SHOULD_BE_PRIVATE)

This class defines a static field 'serialVersionUID' to define the serialization
			version for this class. This field is marked as non private. As the serialVersionUID only
			controls the current class, and doesn't affect any derived classes, defining it as non
			private is confusing. It is suggested you change this variable to be private.