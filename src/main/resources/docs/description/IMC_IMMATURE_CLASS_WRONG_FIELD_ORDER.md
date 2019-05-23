# [Class orders instance fields before static fields](http://fb-contrib.sourceforge.net/bugdescriptions.html#IMC_IMMATURE_CLASS_WRONG_FIELD_ORDER)

This class defines fields in an order that is confusing, and not expected by
    		other developers. The standard is for static fields to be listed first, followed by instance
    		fields. When fields are listed out of order, developers may make assumptions about their
    		behaviour that are incorrect and lead to bugs.