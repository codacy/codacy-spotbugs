# [Do not synchronize on a collection view when the backing collection is accessible](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USBC_UNSAFE_SYNCHRONIZATION_WITH_BACKING_COLLECTION)

      Synchronizing a collection view when its backing collection is accessible can lead to nondeterministic behavior.

      The [Java Wrapper implementations](https://docs.oracle.com/javase/tutorial/collections/implementations/wrapper.html) warns about the consequences
      of synchronizing on the collection view rather than the backing collection itself.
      Failing to comply with this can end up using two distinct locking strategies and violates thread safety.

      To solve this issue, synchronize on the backing collection object instead of the collection view.

      See SEI CERT rule [LCK04-J. Do not synchronize on a collection view if the backing collection is accessible](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck04-j/).