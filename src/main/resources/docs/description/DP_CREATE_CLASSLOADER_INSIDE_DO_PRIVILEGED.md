# [Classloaders should only be created inside doPrivileged block](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED)

 This code creates a classloader,  which needs permission if a security manage is installed.
        If this code might be invoked by code that does not
        have security permissions, then the classloader creation needs to occur inside a doPrivileged block.

        The `java.security.AccessController` class, which contains the `doPrivileged` methods,
        got deprecated in Java 17 (see [JEP 411](https://openjdk.org/jeps/411)), and removed in Java 24 (see [JEP 486](https://openjdk.org/jeps/486)).
        For this reason, this bug isn't reported in classes targeted Java 17 and above.

See [CWE-266: Incorrect Privilege Assignment](https://cwe.mitre.org/data/definitions/266.html).