# [Do not expose inherited lock objects through methods by updating or returning them](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USO_UNSAFE_EXPOSED_OBJECT_SYNCHRONIZATION)

      Synchronizing on a lock that is made accessible in the class hierarchy can lead to security vulnerabilities.
      Untrusted code can access the lock object, and it can exploit the system to execute unsafe operations.

      In scenarios where a thread synchronizes on the lock and enters the synchronized block, an attacker can access the lock object or update its value,
      allowing another thread to synchronize on the new value and concurrently enter the synchronized block.
      Alternatively, an attacker can indefinitely hold the lock object, resulting in a Denial of Service (DoS) scenario.

      This can be resolved in two ways: either by restricting access to the current lock object or using another private final object as lock object.
      Using a private final lock object is generally preferred, as it offers enhanced security and granularity of control.

For more details read SEI CERT rule [LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck00-j/).