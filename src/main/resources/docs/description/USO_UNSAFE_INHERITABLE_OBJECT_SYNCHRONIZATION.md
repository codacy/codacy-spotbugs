# [Use private final lock objects in synchronization blocks, when class can be extended](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USO_UNSAFE_INHERITABLE_OBJECT_SYNCHRONIZATION)

      Declaring a lock object that is visible to outside classes or subclasses might lead to security vulnerabilities.
      Untrusted code can access the lock object, and it can exploit the system to execute unsafe operations.

      In scenarios where a thread synchronizes on the lock and enters the synchronized block, an attacker can access the lock object or update its value,
      allowing another thread to synchronize on the new value and concurrently enter the synchronized block.
      Alternatively, an attacker can indefinitely hold the lock object, resulting in a Denial of Service (DoS) scenario.

      Generally it is not a problem to use a protected or package-private lock object if it is used with great care and thought, but it still might cause problems.
      A protected lock object declared in a non-final class can be accessed by subclasses, which can use the lock object for synchronizing with unrelated operations.
      Similar the case with a package-private lock object, which is exposed to all classes in the package.

      This can be resolved by declaring the lock object as private final, which restricts access to the lock object, providing granularity and enhanced security.

For more details read SEI CERT rule [LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck00-j/).