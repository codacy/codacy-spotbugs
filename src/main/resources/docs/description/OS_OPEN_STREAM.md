# [Method may fail to close stream](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#OS_OPEN_STREAM)

 The method creates an IO stream object, does not assign it to any
fields, pass it to other methods that might close it,
or return it, and does not appear to close
the stream on all paths out of the method.  This may result in
a file descriptor leak.  It is generally a good
idea to use a `finally` block to ensure that streams are
closed.