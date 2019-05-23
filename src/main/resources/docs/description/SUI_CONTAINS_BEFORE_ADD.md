# [Method checks for an item in a set with contains, before using add()](http://fb-contrib.sourceforge.net/bugdescriptions.html#SUI_CONTAINS_BEFORE_ADD)

This method checks to see if an element is not in a set before adding it. This is unnecessary as you can just
            add the item, and if the item exists, it won't add it, otherwise it will.

As an example, instead of using

    Set mySet = getSomeSet(); if (!mySet.contains("foo")) { mySet.add("foo"); }

            convert this to
            `

<pre>
                Set
 <string>

  mySet = getSomeSet(); if (mySet.add("foo")) { } 

 </string></pre>

            `