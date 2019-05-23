# [Method uses Properties.put instead of Properties.setProperty](http://fb-contrib.sourceforge.net/bugdescriptions.html#IPU_IMPROPER_PROPERTIES_USE_SETPROPERTY)

This method uses the inherited method from Hashtable put(String key, Object value) in
			a Properties object. Since the Properties object was intended to be only a String to String
			map, use of the derived put method is discouraged. Use the Properties.setProperty method instead.

			Don't use `properties.put("foo", "bar");`

			Do use `properties.setProperty("foo", "bar");`