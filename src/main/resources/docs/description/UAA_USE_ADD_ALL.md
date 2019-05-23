# [Method uses simple loop to copy contents of one collection to another](http://fb-contrib.sourceforge.net/bugdescriptions.html#UAA_USE_ADD_ALL)

This method uses a simple `for` loop to copy the contents of a set, list, map key/value, array or other collection
			to another collection. It is simpler and more straightforward to just call the addAll method of the destination collection
			passing in the source collection. In the case that the source is an array, you can use the Arrays.asList method to wrap the array
			into a collection.