# [Method puts non-String values into a Properties object](http://fb-contrib.sourceforge.net/bugdescriptions.html#IPU_IMPROPER_PROPERTIES_USE)

This method places non-String objects into a Properties object. As the Properties object
			is intended to be a String to String map, putting non String objects is wrong, and takes advantage
			of a design flaw in the Properties class by deriving from Hashtable instead of using aggregation.
			If you want a collection that holds other types of objects, use a Hashtable, or better still newer collections
			like HashMap or TreeMap.

			Don't use `properties.put("foo", bar);`

			Do use `properties.setProperty("foo", "bar");`