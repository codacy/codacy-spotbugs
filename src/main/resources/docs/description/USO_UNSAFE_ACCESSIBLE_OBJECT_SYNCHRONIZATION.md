# [Use private final lock objects in synchronization blocks when the lock is accessible](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USO_UNSAFE_ACCESSIBLE_OBJECT_SYNCHRONIZATION)

      Synchronizing on a lock object that is made accessible to outside classes by returning it from a method or updating it through a method can lead to security vulnerabilities.
      Untrusted code can gain access to the lock or modify its value and exploit the system.

      In scenarios where a thread synchronizes on the lock and enters the synchronized block, an attacker can access the lock object or update its value,
      allowing another thread to synchronize on the new value and concurrently enter the synchronized block.
      Alternatively, an attacker can indefinitely hold the lock object, resulting in a Denial of Service (DoS) scenario.

      This can be resolved in two ways: either by using another object as a private final lock object, or by removing or restricting the visibility of the functions, which update or return the lock object.
      Using a private final lock object is generally preferred, as it offers enhanced security and granularity of control.

For more details read SEI CERT rule [LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck00-j/).