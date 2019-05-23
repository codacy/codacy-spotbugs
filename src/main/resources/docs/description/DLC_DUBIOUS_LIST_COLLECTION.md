# [Class defines List based fields but uses them like Sets](http://fb-contrib.sourceforge.net/bugdescriptions.html#DLC_DUBIOUS_LIST_COLLECTION)

This class defines a field based on java.util.List, but uses it to some extent like a Set. Since
			lookup type operations are performed using a linear search for Lists, the performance for large
			Lists will be poor. If the list is known to only contain a small number of items (3, 4, etc), then it
			doesn't matter. Otherwise, consider changing this field's implementation to a set-based one. If order of
			iteration is important to maintain insert order, perhaps consider a LinkedHashSet.