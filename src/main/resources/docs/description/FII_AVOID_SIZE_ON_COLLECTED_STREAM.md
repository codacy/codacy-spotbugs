# [Method calls size() on a collected lambda expression](http://fb-contrib.sourceforge.net/bugdescriptions.html#FII_AVOID_SIZE_ON_COLLECTED_STREAM)

This method builds a collection using lambda expressions with a collect terminal operation. It then immediately
        calls the size() method on it, to get a count of items. This is sub optimal as the lambda still needs to 
        build the entire collection, iterating the entire source list. It is better to use count() predicate to short
        circuit the building of the collection. If you were using a Set, then also add the distinct() predicate.

        Instead of

    baubles.stream().filter(b -> b.getName("orb")).collect(Collectors.toList()).size())

        do
        `
        baubles.stream().filter(b -> b.getName("orb")).count()
        `
        or for sets you can use
        `
        baubles.stream().filter(b -> b.getName("orb")).distinct().count()
        `