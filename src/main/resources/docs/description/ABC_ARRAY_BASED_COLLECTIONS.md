# [Method uses array as basis of collection](http://fb-contrib.sourceforge.net/bugdescriptions.html#ABC_ARRAY_BASED_COLLECTIONS)

This method passes an array as the key to a Map, element in a Set, or item in a List when
			the contains method is used on the List. Since arrays do not and cannot override the `equals`
			method, collection inclusion is based on the reference's address, which is probably not desired.
			In the case that this is a TreeMap or TreeSet, consider passing a Comparator to the map's
			constructor.