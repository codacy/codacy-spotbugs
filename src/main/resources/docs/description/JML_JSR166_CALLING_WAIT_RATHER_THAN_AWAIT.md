# [Using monitor style wait methods on util.concurrent abstraction](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#JML_JSR166_CALLING_WAIT_RATHER_THAN_AWAIT)

 This method calls
`wait()`,
`notify()` or
`notifyAll()`
on an object that also provides an
`await()`,
`signal()`,
`signalAll()` method (such as util.concurrent Condition objects).
This probably isn't what you want, and even if you do want it, you should consider changing
your design, as other developers will find it exceptionally confusing.