# [Method gets and sets a value of a ConcurrentHashMap in a racy manner](http://fb-contrib.sourceforge.net/bugdescriptions.html#CCI_CONCURRENT_COLLECTION_ISSUES_USE_PUT_IS_RACY)

This method retrieves the value of a key from a ConcurrentHashMap, where the value is itself a collection. It checks this
    		value for null, and if it is so, creates a new collection and places it in the map. This may cause thread race conditions
    		where two threads overwrite each other's values. You should be using
    		`
    			ConcurrentHashMap.putIfAbsent(K, V)
    		`
    		instead.