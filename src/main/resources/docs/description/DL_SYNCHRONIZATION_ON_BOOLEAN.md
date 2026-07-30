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

See CERT [LCK01-J. Do not synchronize on objects that may be reused](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck01-j/)
and [CWE-412: Unrestricted Externally Accessible Lock](https://cwe.mitre.org/data/definitions/412.html)
for more information.