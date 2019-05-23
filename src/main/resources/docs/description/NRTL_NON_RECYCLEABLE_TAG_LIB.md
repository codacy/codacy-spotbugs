# [Tag library is not recycleable](http://fb-contrib.sourceforge.net/bugdescriptions.html#NRTL_NON_RECYCLEABLE_TAG_LIB)

This tag library class implements an attribute whose associated backing store field
			is modified at another point in the tag library. In order for a tag library to be
			recycleable, only the container is allowed to change this attribute, through the use
			of the setXXX method of the taglib. By modifying the value programmatically, the
			container will not initialize the attribute correctly on reuse.