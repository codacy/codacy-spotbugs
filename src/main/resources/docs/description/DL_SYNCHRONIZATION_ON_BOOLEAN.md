# [Synchronization on Boolean](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DL_SYNCHRONIZATION_ON_BOOLEAN)

 The code synchronizes on a boxed primitive constant, such as a Boolean.

    private static Boolean inited = Boolean.FALSE;
    ...
    synchronized(inited) {
        if (!inited) {
            init();
            inited = Boolean.TRUE;
        }
    }
    ...

Since there normally exist only two Boolean objects, this code could be synchronizing on the same object as other, unrelated code, leading to unresponsiveness
and possible deadlock.

See CERT [CON08-J. Do not synchronize on objects that may be reused](https://www.securecoding.cert.org/confluence/display/java/CON08-J.+Do+not+synchronize+on+objects+that+may+be+reused) for more information.