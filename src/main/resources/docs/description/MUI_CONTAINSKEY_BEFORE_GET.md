# [Method check a map with containsKey(), before using get()](http://fb-contrib.sourceforge.net/bugdescriptions.html#MUI_CONTAINSKEY_BEFORE_GET)

This method checks for the presence of a key in a map using containsKey(), before attempting to fetch the value of the key
    	    using get(). This equates to doing two map lookups in a row. It is much simpler to just fetch the value with get, and checking
    	    for non null instead.

As an example, instead of using

    Map myMap = getSomeMap(); if (myMap.containsKey("foo")) { String value = myMap.get("foo"); .... }

    	    convert this to
    	    `

<pre>
     	    	Map
 <string, string>

  myMap = getSomeMap(); String value = myMap.get("foo"); if (value != null) { .... } 

 </string,></pre>

    	    `

The only caveat to this is that if you use a null value in a map to represent a third state for the key, then in this case
    	    using containsKey is 'correct'. This means an entry found in the map with a null value is taken differently than no entry
    	    at all. However, this is a very subtle programming paradigm, and likely to cause problems. If you wish to mark an entry as
    	    not being present, it is better to use a named 'sentinel' value to denote this, so instead of:

    Map myMap = getSomeMap(); if (myMap.containsKey("foo")) { String value = myMap.get("foo"); .... }

    	    convert this to
    	    `

<pre>
     	    	Map
 <string, string>

  myMap = getSomeMap(); String value = myMap.get("foo"); if (NOT_FOUND.equals(value)) { .... } where NOT_FOUND is some constant that denotes this special status. Of course you will need to find a special sentinel value for each type you are using that isn't possible to have normally. 

 </string,></pre>

    	    `