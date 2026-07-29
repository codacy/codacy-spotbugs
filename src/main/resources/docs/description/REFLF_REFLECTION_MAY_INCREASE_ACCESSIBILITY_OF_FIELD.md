# [Public method uses reflection to modify a field it gets in its parameter which could increase the accessibility of any class](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#REFLF_REFLECTION_MAY_INCREASE_ACCESSIBILITY_OF_FIELD)

        [SEI CERT SEC05-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/platform-security-sec/sec05-j/) rule forbids the use of reflection to increase accessibility of classes, methods or fields. If
        a class in a package provides a public method which takes an instance of java.lang.reflect.Field as its
        parameter and calls a setter (or setAccessible()) method then it increases accessibility of fields in the same
        package which are private, protected or package private. An attacker code may call this method and pass such
        field to change it. This should be avoided by either making the method non-public or by checking for package
        access permission on the package.

        See [CWE-470: Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')](https://cwe.mitre.org/data/definitions/470.html).