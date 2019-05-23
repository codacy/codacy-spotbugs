# [Method uses integer based for loops to iterate over a List](http://fb-contrib.sourceforge.net/bugdescriptions.html#LII_LIST_INDEXED_ITERATING)

This method uses an integer-based `for` loop to iterate over a java.util.List, by calling
			List.get(i) each time through the loop. The integer is not used for other reasons. It is better
			to use an Iterator instead, as depending on List implementation, iterators can perform better,
			and they also allow for exchanging of other collection types without issue.