# [Synchronization on boxed primitive values](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DL_SYNCHRONIZATION_ON_UNSHARED_BOXED_PRIMITIVE)

 The code synchronizes on an apparently unshared boxed primitive,
such as an Integer.

    private static final Integer fileLock = new Integer(1);
    ...
    synchronized(fileLock) {
        .. do something ..
    }
    ...

It would be much better, in this code, to redeclare fileLock as

    private static final Object fileLock = new Object();

The existing code might be OK, but it is confusing and a
future refactoring, such as the "Remove Boxing" refactoring in IntelliJ,
might replace this with the use of an interned Integer object shared
throughout the JVM, leading to very confusing behavior and potential deadlock.