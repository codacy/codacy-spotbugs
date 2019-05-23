# [Collection variable is named with a different type of collection in the name](http://fb-contrib.sourceforge.net/bugdescriptions.html#CNC_COLLECTION_NAMING_CONFUSION)

This class defines a field or local collection variable with a name that contains a different type
            of collection in its name. An example would be a Set<user>
  called userList. This is confusing to the reader, and likely caused by a previous refactor of type, without changing the name. This detector is obviously only checking for English names.
</user>