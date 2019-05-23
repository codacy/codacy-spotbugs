# [Class defines unneeded synchronization on member collection](http://fb-contrib.sourceforge.net/bugdescriptions.html#NMCS_NEEDLESS_MEMBER_COLLECTION_SYNCHRONIZATION)

This class defines a private collection member as synchronized. It appears, however,
			that this collection is only modified in a static initializer, or constructor. As these
			two areas are guaranteed to be thread safe, defining this collection as synchronized is
			unnecessary and a potential performance bottleneck.