# [This method attempts to modify collection that appears to possibly be immutable](http://fb-contrib.sourceforge.net/bugdescriptions.html#MUC_MODIFYING_UNMODIFIABLE_COLLECTION)

This method attempts to modify a collection that it got from a source that could potentially have created an
            immutable collection, through Arrays.asList, Collections.unmodifiableXXX, or one of Guava's methods.
            Doing so will cause an exception, as these collections are not mutable.