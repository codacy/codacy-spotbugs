# [Method passes a temporary one item list to Collection.addAll()](http://fb-contrib.sourceforge.net/bugdescriptions.html#LUI_USE_COLLECTION_ADD)

This method creates a temporary list using Collections.singletonList, or Arrays.asList with one
    	element in it, and then turns around and calls the addAll() method on another collection. Since you
    	are only adding one element to the collection, it is simpler to just call the add(object) method on
    	the collection you are using and by pass creating the intermediate List.