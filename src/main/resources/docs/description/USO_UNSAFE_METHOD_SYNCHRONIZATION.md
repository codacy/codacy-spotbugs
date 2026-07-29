# [Instead of synchronized methods, use private final lock objects with block synchronization](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USO_UNSAFE_METHOD_SYNCHRONIZATION)

      Synchronized methods use the class object as a monitor (that is, its intrinsic lock), thus an attacker, if it has access to the object,
      can exploit the system by indefinitely locking the object, leading to a Denial of Service (DoS) scenario.

      This can be resolved in two ways: either by using a private final lock object with block synchronization or by restricting access to the class.
      Using a private final lock object is generally preferred, as it offers enhanced security and granularity of control.

For more details read SEI CERT rule [LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/locking-lck/lck00-j/).