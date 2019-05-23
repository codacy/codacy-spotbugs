# [Method suboptimally finds any match in a stream](http://fb-contrib.sourceforge.net/bugdescriptions.html#FII_USE_ANY_MATCH)

This method looks for one item in a stream using filter().findFirst.isPresent() when .anyMatch() will do the same thing more succintly