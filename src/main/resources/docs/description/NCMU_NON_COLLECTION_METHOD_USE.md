# [Method uses old non collections interface methods](http://fb-contrib.sourceforge.net/bugdescriptions.html#NCMU_NON_COLLECTION_METHOD_USE)

This method makes calls to collection classes where the method is not defined by the Collections
			interface, and an equivalent method exists in the interface. By using the new methods,
			you can define this object by the Collections interface and allow better decoupling.