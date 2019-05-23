# [Class does not implement an equals method](http://fb-contrib.sourceforge.net/bugdescriptions.html#IMC_IMMATURE_CLASS_NO_EQUALS)

This class, which has instance fields, has no equals(Object o) method. It is possible that this
    		class is never used in a context where this is required; it is often assumed, however, from clients
    		of this class that it is, so it is good to add such methods when you create them.