# [Method uses a set of collections](http://fb-contrib.sourceforge.net/bugdescriptions.html#DSOC_DUBIOUS_SET_OF_COLLECTIONS)

This method creates a set that contains other collections, or a Map whose keySet is
			another collection. As collections tend to calculate hashCode, equals, and compareTo by
			iterating the contents of the collection, this can perform poorly.

In addition, when a set is used, you typically are using it to do 'contains', or 'find'
			type functionality, which seems dubious when done on a collection.

Finally, as a collection is often modified, problems will occur if the collection is
			contained in a set, because the hashCode, equals or compareTo values will change while the
			collection is in the set.

If you wish to maintain a collection of collections, it is probably better to use a List
			as the outer collection.