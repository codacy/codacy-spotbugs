# [Method uses collection streaming to get first item in a List](http://fb-contrib.sourceforge.net/bugdescriptions.html#LUI_USE_GET0)

This method fetches the first item in a List using collection streaming. As a list is already ordered
    	there is no need to do that, just use the regular get(0) interface.  

    	Example:

    String s = myList.stream().findFirst().get();

    	Can be more simply done using
    	`

<pre>
    	String s = myList.get(0);
    	</pre>

`