# [Synchronization on interned String](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DL_SYNCHRONIZATION_ON_INTERNED_STRING)

 The code synchronizes on interned String.

    private static String LOCK = new String("LOCK").intern();
    ...
    synchronized(LOCK) {
        ...
    }
    ...

Constant Strings are interned and shared across all other classes loaded by the JVM. Thus, this code
is locking on something that other code might also be locking. This could result in very strange and hard to diagnose
blocking and deadlock behavior. See [http://www.javalobby.org/java/forums/t96352.html](http://www.javalobby.org/java/forums/t96352.html) and [http://jira.codehaus.org/browse/JETTY-352](http://jira.codehaus.org/browse/JETTY-352).

See CERT [LCK01-J. Do not synchronize on objects that may be reused](https://wiki.sei.cmu.edu/confluence/display/java/LCK01-J.+Do+not+synchronize+on+objects+that+may+be+reused) for more information.