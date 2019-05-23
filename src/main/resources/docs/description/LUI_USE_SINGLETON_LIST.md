# [Method builds a list from one element using Arrays.asList](http://fb-contrib.sourceforge.net/bugdescriptions.html#LUI_USE_SINGLETON_LIST)

This method builds a list using Arrays.asList(foo), passing in a single element. Arrays.asList needs to first create an array from this one
    	element, and then build a List that wraps this array. It is simpler to use Collections.singletonList(foo), which does not create the array, and
    	produces a far simpler instance of List. Since both of these arrays are immutable (from the List's point of view) they are equivalent from a usage
    	standpoint.

There is one difference between Array.asList and Collections.singletonList that you should be mindful of. The rarely used set(index, value) method is
    	allowed to be used with a List created by Array.asList, but not with Collections.singletonList. So if you do use the set(index, value) method
    	continue using Arrays.asList.