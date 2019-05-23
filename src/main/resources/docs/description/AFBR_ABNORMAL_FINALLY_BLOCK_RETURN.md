# [Method has abnormal exit from finally block](http://fb-contrib.sourceforge.net/bugdescriptions.html#AFBR_ABNORMAL_FINALLY_BLOCK_RETURN)

This method returns or throws exceptions from a finally block. This will
			mask real program logic in the try block, and short-circuit normal method termination.