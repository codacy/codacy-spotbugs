# [Method creates an anonymous lambda expression instead of specifying a method reference](http://fb-contrib.sourceforge.net/bugdescriptions.html#FII_USE_METHOD_REFERENCE)

This method defines an anonymous lambda function to be called to fetch a single value from the passed in value. While
    	this will work, it is needlessly complex as this function merely calls a single getter method on the object, and thus
    	the code can be simplied by just passing in a method reference instead.

        Instead of

    baubles.stream().map(b -> b.getName()).collect(Collectors.toSet())

        do
        `
        baubles.stream().map(Bauble::getName).collect(Collectors.toSet())
        `