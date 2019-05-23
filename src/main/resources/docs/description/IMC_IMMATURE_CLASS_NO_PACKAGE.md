# [Class is defined in the default package](http://fb-contrib.sourceforge.net/bugdescriptions.html#IMC_IMMATURE_CLASS_NO_PACKAGE)

This class has been created in the default package. Classes should be defined in a
    		proper package structure, typically defined by the reverse of the domain name of the
    		owner of the code base. Putting code in the default (no) package limits its usefulness, including:

1.  Not being able to import this class into classes with packages
2.  Leaving it open to name collisions with other packages.