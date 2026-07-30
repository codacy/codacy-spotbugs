# [Operation on shared variable is not atomic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AT_NONATOMIC_OPERATIONS_ON_SHARED_VARIABLE)

          This write of a variable shared between functions depends on the current value of the variable (either because it's a compound operation - e.g. +=, ++ - or it simply depends on the current value), as such it consists of more than one discrete operation.
          These operations are not atomic in themselves and need further synchronization.
          See [SEI CERT rule VNA02-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/visibility-and-atomicity-vna/vna02-j/),
          [CWE-366: Race Condition within a Thread](https://cwe.mitre.org/data/definitions/366.html),
          [CWE-413: Improper Resource Locking](https://cwe.mitre.org/data/definitions/413.html),
          [CWE-567: Unsynchronized Access to Shared Data in a Multithreaded Context](https://cwe.mitre.org/data/definitions/567.html), and
          [CWE-667: Improper Locking](https://cwe.mitre.org/data/definitions/667.html).

          Simply declaring a variable volatile fails to guarantee the atomicity of compound operations on the variable,
          but synchronizing the writes on top of declaring the variable volatile for read operations is sufficient.

          To solve this issue, synchronize compound operations and other write operations depending on the previous value,
          use read-write locks, or declare the shared variable with an atomic type.