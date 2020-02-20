# [Synchronization on interned String](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DL_SYNCHRONIZATION_ON_SHARED_CONSTANT)

 The code synchronizes on interned String.

    private static String LOCK = "LOCK";
    ...
    synchronized(LOCK) {
        ...
    }
    ...

Constant Strings are interned and shared across all other classes loaded by the JVM. Thus, this code
is locking on something that other code might also be locking. This could result in very strange and hard to diagnose
blocking and deadlock behavior. See [http://www.javalobby.org/java/forums/t96352.html](http://www.javalobby.org/java/forums/t96352.html) and [http://jira.codehaus.org/browse/JETTY-352](http://jira.codehaus.org/browse/JETTY-352).

See CERT [CON08-J. Do not synchronize on objects that may be reused](https://www.securecoding.cert.org/confluence/display/java/CON08-J.+Do+not+synchronize+on+objects+that+may+be+reused) for more information.