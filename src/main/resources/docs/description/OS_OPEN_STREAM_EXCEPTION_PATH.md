# [Method may fail to close stream on exception](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#OS_OPEN_STREAM_EXCEPTION_PATH)

 The method creates an IO stream object, does not assign it to any
fields, pass it to other methods, or return it, and does not appear to close
it on all possible exception paths out of the method. 
This may result in a file descriptor leak.  It is generally a good
idea to use a `finally` block to ensure that streams are
closed.