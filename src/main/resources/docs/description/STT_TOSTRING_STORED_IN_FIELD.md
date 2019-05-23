# [This method stores the value of a toString() call into a field](http://fb-contrib.sourceforge.net/bugdescriptions.html#STT_TOSTRING_STORED_IN_FIELD)

This method calls the toString() method on an object and stores the value in a field. Doing this
            throws away the type safety of having the object defined by a Class. Using String makes it very easy to
            use the wrong type of value, and the compiler will not catch these mistakes. You should delay converting
            values to Strings for as long as possible, and thus not store them as fields.