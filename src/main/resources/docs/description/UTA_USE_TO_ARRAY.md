# [Method manually creates array from collection](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTA_USE_TO_ARRAY)

This method manually loops over a collection, pulling each element out and storing
			it in an array to build an array from the collection. It is easier and clearer to use
			the built-in Collection method toArray. Given a collection 'mycollection' of type T, use
			`mycollection.toArray(new T[mycollection.size()]);`