# [Method deletes collection element while iterating](http://fb-contrib.sourceforge.net/bugdescriptions.html#DWI_DELETING_WHILE_ITERATING)

This method removes items from a collection using the remove method of the collection, while
			at the same time iterating across the collection. Doing this will invalidate the iterator, and further
			use of it will cause ConcurrentModificationException to be thrown. To avoid this, the remove
			method of the iterator should be used.