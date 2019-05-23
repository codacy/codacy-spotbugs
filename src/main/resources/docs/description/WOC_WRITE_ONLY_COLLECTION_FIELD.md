# [Class creates and initializes a collection but never reads or gains information from it](http://fb-contrib.sourceforge.net/bugdescriptions.html#WOC_WRITE_ONLY_COLLECTION_FIELD)

This class creates and initializes a collection as a field but then never accesses this collection
			to gain information or fetch items from the collection. It is likely that this collection
			is left over from a past effort, and can be removed.