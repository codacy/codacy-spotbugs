# [This write of this 64-bit primitive variable may not be atomic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AT_NONATOMIC_64BIT_PRIMITIVE)

          The long and the double are 64-bit primitive types, and depending on the Java Virtual Machine implementation assigning a value to them can be treated as two separate 32-bit writes, and as such it's not atomic.
          See [JSL 17.7\. Non-Atomic Treatment of double and long](https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.7).
          See SEI CERT rule [VNA05-J. Ensure atomicity when reading and writing 64-bit values](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/visibility-and-atomicity-vna/vna05-j/) and
          [CWE-667: Improper Locking](https://cwe.mitre.org/data/definitions/667.html) for more info.

          This bug can be ignored in platforms which guarantee that 64-bit long and double type read and write operations are atomic.

          To fix it, declare the variable volatile, change the type of the field to the corresponding atomic type from `java.lang.concurrent.atomic` or correctly synchronize the code.
          Declaring the variable volatile may not be enough in some cases: e.g. when the variable is assigned a value which depends on the current value or on the result of nonatomic compound operations.