# [Use private final lock objects in synchronization blocks](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USO_UNSAFE_OBJECT_SYNCHRONIZATION)

      Synchronizing on a non-private lock object can lead to security vulnerabilities.
      Untrusted code can gain access to the lock object, and can exploit the system to execute unsafe operations.

      In scenarios where a thread synchronizes on the lock and enters the synchronized block, untrusted code can manipulate the lock object,
      allowing another thread to synchronize on the new value and concurrently enter the synchronized block.
      Alternatively, an attacker can indefinitely hold the lock object, resulting in a Denial of Service (DoS) scenario.

      A public lock object can be accessed directly by untrusted code, while protected lock objects expose the lock object to subclasses. Then subclasses can use the lock object for synchronizing with unrelated operations.
      Generally a package-private lock object can be useful inside a sealed package if used with care, but it is still exposed to all classes in the package.

      This can be resolved by declaring the lock object as private final, which restricts access to the lock object, providing granularity and enhanced security.

For more details read SEI CERT rule [LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck00-j/).