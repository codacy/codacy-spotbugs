# [Method passes a Buffered Stream/Reader/Writer to a already buffering copy method](http://fb-contrib.sourceforge.net/bugdescriptions.html#IOI_DOUBLE_BUFFER_COPY)

This method copies data from input to output using streams or reader/writers using a well known copy method, from java.nio, commons-io,
    		springframework, guava or poi. These methods are efficient in that they copy these files using buffers. However, this method is also
    		buffering the streams, causing a double buffering to occur. So data first goes to one buffer, then is copied to another buffer, before
    		making it to the destination (or vice-versa). This just causes the copy operation to be inefficient both from a time perspective and
    		a memory allocation one. When using these copy methods, do not pass buffered streams/readers/writers.