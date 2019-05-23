# [Method creates a ZLIB Inflater or Deflater and doesn't appear to end() it](http://fb-contrib.sourceforge.net/bugdescriptions.html#IOI_UNENDED_ZLIB_OBJECT)

This method constructs a java.util.zip.Inflater or java.util.zip.Deflater and does not appear to call end() on
    		it. This will cause a potentially large amount of memory to hang around inside the object until the object gets 
    		garbage collected. To avoid this unnecessary bloat, put a call to end() in a finally block of the code where you
    		are using this instance.