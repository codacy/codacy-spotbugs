# [Instead of static synchronized methods, use private final lock objects with block synchronization](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USO_UNSAFE_STATIC_METHOD_SYNCHRONIZATION)

      Static synchronized methods use the class object as a monitor (that is, its intrinsic lock), thus an attacker,
      if it has access to an instance of the class or the subclass, can gain access to the class object using `getClass()` and
      indefinitely lock the object, leading to a Denial of Service (DoS) scenario.

      This can be resolved in two ways: either by using a private static final lock object with block synchronization or by restricting access to the class.
      Using a private final lock object is generally preferred, as it offers enhanced security and granularity of control.

For more details read SEI CERT rule [LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck00-j/).