# [Comparator method doesn't seem to return all ordering values](http://fb-contrib.sourceforge.net/bugdescriptions.html#SCRV_SUSPICIOUS_COMPARATOR_RETURN_VALUES)

This compareTo or compare method returns constant values to represent less than,
			equals, and greater than. However, it does not return each type, or it unconditionally returns a non zero value.
			Given that comparators are transitive, this seems incorrect.