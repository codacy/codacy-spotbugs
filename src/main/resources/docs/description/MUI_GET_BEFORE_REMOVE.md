# [Method gets an item from a map with get(), before using remove()](http://fb-contrib.sourceforge.net/bugdescriptions.html#MUI_GET_BEFORE_REMOVE)

This method fetches the value of an entry in a map using get(K k), and then follows it up with a remove(K k).
    		Since a remove() also returns the value, there is no point for doing the get, and just causes two map lookups
    		to occur when it can be done with just one.

As an example, instead of using

    Map myMap = getSomeMap(); String v = myMap.get("foo")) { myMap.remove("foo");

    	    convert this to
    	    `

<pre>
     	    	Map
 <string, string>

  myMap = getSomeMap(); String v = myMap.remove("foo"); 

 </string,></pre>

    	    `