# [Method calls contains() on a collected lambda expression](http://fb-contrib.sourceforge.net/bugdescriptions.html#FII_AVOID_CONTAINS_ON_COLLECTED_STREAM)

This method builds a collection using lambda expressions with a collect terminal operation. It then immediately
        calls the contains() method on it, to see if an item is present. This is sub optimal as the lambda still needs to 
        build the entire collection, iterating the entire source list. It is better to use anyMatch() to short
        circuit the building of the collection.

        Instead of

    baubles.stream().map(Bauble::getName).collect(Collectors.toSet()).contains(name)

        do
        `
        baubles.stream().anyMatch(b -> name.equals(b.getName()))
        `