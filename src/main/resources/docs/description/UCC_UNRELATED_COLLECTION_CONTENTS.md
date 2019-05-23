# [Method adds unrelated types to collection or array](http://fb-contrib.sourceforge.net/bugdescriptions.html#UCC_UNRELATED_COLLECTION_CONTENTS)

This method adds unrelated objects to a collection or array, requiring careful and brittle
			data access to that collection. Create a separate class with the properties needed, and add
			an instance of this class to the collection or array, if possible.