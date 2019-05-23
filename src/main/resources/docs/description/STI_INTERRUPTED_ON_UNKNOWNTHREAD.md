# [Static Thread.interrupted() method invoked on thread instance](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#STI_INTERRUPTED_ON_UNKNOWNTHREAD)

This method invokes the Thread.interrupted() method on a Thread object that appears to be a Thread object that is
not the current thread. As the interrupted() method is static, the interrupted method will be called on a different
object than the one the author intended.