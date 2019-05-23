# [This method uses a concatenated String as a map key](http://fb-contrib.sourceforge.net/bugdescriptions.html#STT_TOSTRING_MAP_KEYING)

This method builds a key for a map, using a StringBuilder, either implicitly or explicitly. This means the type
    		of the key is something more than a String constant, it is a properly formatted String. However, there is no
    		type based verification that all uses of this key will follow this formatting. It is much better to use a proper, simple,
    		bean class that holds two (or more) fields so that it is clear what is expected for key use.

    		Example  

    			instead of

    V v = myMap.get(tableName + "-" + columnName);

    			use

    V v = myMap.get(new ColumnSpec(tableName, columnName));

    			where ColumnSpec is a simple bean-like class of your creation. The advantages, are

*   The ColumnSpec fully describes what is expected, you need a tableName and columnName
*   There is no guessing by the programmer what the format is, was it tableName + "_" + columnName?