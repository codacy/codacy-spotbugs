# [Class does not implement a hashCode method](http://fb-contrib.sourceforge.net/bugdescriptions.html#IMC_IMMATURE_CLASS_NO_HASHCODE)

This class, which has instance fields, has no hashCode() method. It is possible that this
    		class is never used in a context where this is required; it is often assumed, however, from clients
    		of this class that it is, so it is good to add such methods when you create them.