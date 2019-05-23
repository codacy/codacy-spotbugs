# [Method creates and initializes a collection but never reads or gains information from it](http://fb-contrib.sourceforge.net/bugdescriptions.html#WOC_WRITE_ONLY_COLLECTION_LOCAL)

This method creates and initializes a collection but then never accesses this collection
			to gain information or fetch items from the collection. It is likely that this collection
			is left over from a past effort, and can be removed.