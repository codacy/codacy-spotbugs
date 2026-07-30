# [This write of this shared primitive variable may not be visible to other threads](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AT_STALE_THREAD_WRITE_OF_PRIMITIVE)

          [SEI CERT rule VNA00-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/visibility-and-atomicity-vna/vna00-j/)
          describes that reading a shared primitive variable in one thread may not yield the value of the most recent write to the variable from another thread.
          Consequently, the thread may observe a stale value of the shared variable.

          To fix it, declare the variable volatile, change the type of the field to the corresponding atomic type from `java.lang.concurrent.atomic` or correctly synchronize the code.
          Declaring the variable volatile may not be enough in some cases: e.g. when the variable is assigned a value which depends on the current value or on the result of nonatomic compound operations.
          This guarantees that 64-bit primitive long and double variables are accessed atomically.

        See also [CWE-413: Improper Resource Locking](https://cwe.mitre.org/data/definitions/413.html),
        [CWE-567: Unsynchronized Access to Shared Data in a Multithreaded Context](https://cwe.mitre.org/data/definitions/567.html), and
        [CWE-667: Improper Locking](https://cwe.mitre.org/data/definitions/667.html).