# [Method checks the size of a collection against zero rather than using isEmpty()](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_ISEMPTY)

This method calls the size() method on a collection and compares the result to zero to see if the collection
			is empty. For better code clarity, it is better to just use col.isEmpty() or !col.isEmpty().