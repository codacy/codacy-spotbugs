# [Method uses iterator().next() on a List to get the first item](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_GET0)

This method calls myList.iterator().next() on a List to get the first item. It is more performant
			to just use myList.get(0).