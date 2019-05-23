# [Method manually handles closing an auto-closeable resource](http://fb-contrib.sourceforge.net/bugdescriptions.html#UTWR_USE_TRY_WITH_RESOURCES)

    		[

This method allocates and uses an auto closeable resource. However, it manually closes the resource in a finally block.
    		While this is correct management, it doesn't rely on the idiomatic way available to JDK 7 and above, allows for possible
    		subtle problems, and complicates the reading of code by developers expecting the use of try-with-resources.

Switch to using try with resources, as:

<pre>
    		    try (InputStream is = getAStream()) {
    		        useTheStream(is);
    		    }
    		</pre>