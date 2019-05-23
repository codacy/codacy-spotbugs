# [Method collects a List from a stream() just to get the first element](http://fb-contrib.sourceforge.net/bugdescriptions.html#FII_USE_FIND_FIRST)

This method streams data into a List just to call get(0) to get the first item. You can just use findFirst() to short circuit the
        processing of the stream.

        Instead of

    baubles.stream().collect(Collectors.toList()).get(0)

        do
        `
        baubles.stream().findFirst().get())
        `