# [Synchronization on boxed primitive](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DL_SYNCHRONIZATION_ON_BOXED_PRIMITIVE)

 The code synchronizes on a boxed primitive constant, such as an Integer.

    private static Integer count = 0;
    ...
    synchronized(count) {
        count++;
    }
    ...

Since Integer objects can be cached and shared,
this code could be synchronizing on the same object as other, unrelated code, leading to unresponsiveness
and possible deadlock.

See CERT [LCK01-J. Do not synchronize on objects that may be reused](https://wiki.sei.cmu.edu/confluence/display/java/LCK01-J.+Do+not+synchronize+on+objects+that+may+be+reused) for more information.