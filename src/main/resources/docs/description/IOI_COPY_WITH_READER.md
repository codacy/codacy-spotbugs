# [Method performs bulk stream copy with a java.io.Reader derived input](http://fb-contrib.sourceforge.net/bugdescriptions.html#IOI_COPY_WITH_READER)

This method copies data from a java.io.Reader derived class to an output class, using a bulk copy method
    		supplied by java.nio, commons-io, springframework, guava or poi. Since you are copying the entire stream, you
    		don't care about its contents, and thus using a Reader is wasteful, as a reader has to do the hard work of
    		converting byte data to characters, when there is no need to do this. Use stream based inputs for better performance.