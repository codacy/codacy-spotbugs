# [Method creates iterators on synchronized collections](http://fb-contrib.sourceforge.net/bugdescriptions.html#SCI_SYNCHRONIZED_COLLECTION_ITERATORS)

This method uses a synchronized collection, built from Collections.synchronizedXXXX, but accesses it
			through an iterator. Since an iterator is, by definition, multithreading-unsafe, this is a conflict in
			concept. When using iterators, you should do the synchronization manually.