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

See CERT [LCK01-J. Do not synchronize on objects that may be reused](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck01-j/)
and [CWE-412: Unrestricted Externally Accessible Lock](https://cwe.mitre.org/data/definitions/412.html)
for more information.