# [Class holds a map-type field, but uses it as only a List](http://fb-contrib.sourceforge.net/bugdescriptions.html#DMC_DUBIOUS_MAP_COLLECTION)

This method instantiates a map-type field in a static initializer or constructor, but then only uses it
			through iteration. This means that this data structure should really just be a List<SomeObject>,
			where the class held by the list contains the two fields held by the key and value of the Map.
			It was likely done this way to avoid having to create a class, but this just obfuscates the purpose of the field.