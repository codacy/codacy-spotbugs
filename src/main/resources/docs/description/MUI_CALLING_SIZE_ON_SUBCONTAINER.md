# [Method calls size() on a sub collection of a Map](http://fb-contrib.sourceforge.net/bugdescriptions.html#MUI_CALLING_SIZE_ON_SUBCONTAINER)

This method calls `size` on the keySet(), entrySet() or values() collections of a Map. These sub collections
    		will have the same size as the base Map and so it is just simpler to call size on that Map. Calling size() on
    		one of these sub collections will causes unnecessary allocations to occur.