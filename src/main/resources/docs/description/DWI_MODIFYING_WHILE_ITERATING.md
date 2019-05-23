# [Method modifies collection element while iterating](http://fb-contrib.sourceforge.net/bugdescriptions.html#DWI_MODIFYING_WHILE_ITERATING)

This method modifies the contents of a collection using the collection API methods, while
			at the same time iterating across the collection. Doing this will invalidate the iterator, and further
			use of it will cause ConcurrentModificationException to be thrown.