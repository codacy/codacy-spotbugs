# [Unneeded use of currentThread() call, to call interrupted() ](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#STI_INTERRUPTED_ON_CURRENTTHREAD)

This method invokes the Thread.currentThread() call, just to call the interrupted() method. As interrupted() is a
static method, is more simple and clear to use Thread.interrupted().