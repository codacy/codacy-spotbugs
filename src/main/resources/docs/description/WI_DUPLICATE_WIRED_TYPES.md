# [Class auto wires the same object into two separate fields in a class hierarchy](http://fb-contrib.sourceforge.net/bugdescriptions.html#WI_DUPLICATE_WIRED_TYPES)

This class has two fields in either itself or a parent class, which autowire (without specialization) the same object
    		for both fields. This is likely caused by a developer just not being aware that the field already is available for your use,
    		and just causes wasted space, and confuses code access to the same object through two different pathways.