# [Method invoked that should be only be invoked inside a doPrivileged block](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DP_DO_INSIDE_DO_PRIVILEGED)

 This code invokes a method that requires a security permission check.
        If this code will be granted security permissions, but might be invoked by code that does not
        have security permissions, then the invocation needs to occur inside a doPrivileged block.

        The `java.security.AccessController` class, which contains the `doPrivileged` methods,
        got deprecated in Java 17 (see [JEP 411](https://openjdk.org/jeps/411)), and removed in Java 24 (see [JEP 486](https://openjdk.org/jeps/486)).
        For this reason, this bug isn't reported in classes targeted Java 17 and above.

See [CWE-266: Incorrect Privilege Assignment](https://cwe.mitre.org/data/definitions/266.html).