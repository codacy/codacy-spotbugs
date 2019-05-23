# [Method checks for an item in a set with contains, before using remove()](http://fb-contrib.sourceforge.net/bugdescriptions.html#SUI_CONTAINS_BEFORE_REMOVE)

This method checks to see if an element is in a set before removing it. This is unnecessary as you can just
            remove the item, and if the item exists, it will return true.

As an example, instead of using

    Set mySet = getSomeSet(); if (mySet.contains("foo")) { mySet.remove("foo"); }

            convert this to
            `

<pre>
                Set
 <string>

  mySet = getSomeSet(); if (mySet.remove("foo")) { } 

 </string></pre>

            `