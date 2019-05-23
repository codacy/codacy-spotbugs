# [Method uses AccessibleObject.setAccessible to modify accessibility of classes](http://fb-contrib.sourceforge.net/bugdescriptions.html#RFI_SET_ACCESSIBLE)

This method uses the reflective setAccessible method to alter the behavior of methods and fields in classes
    		in ways that were not expected to be accessed by the author. Doing so circumvents the protections that the author
    		provided through the class definition, and may expose your application to unexpected side effects and problems. This
    		functionality is deprecated in Java 9, and in Java 10 it is expected that this functionality won't work at all.