# [Operation on resource is not safe in a multithreaded context](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AT_UNSAFE_RESOURCE_ACCESS_IN_THREAD)

This code contains an operation on a resource that is not safe in a multithreaded context.
            The resource may be accessed by multiple threads concurrently without proper synchronization.
            This may lead to data corruption. Use synchronization or other
            concurrency control mechanisms to ensure that the resource is accessed safely.

See the related SEI CERT rule, but the detector is not restricted to chained methods:
          [
          VNA04-J. Ensure that calls to chained methods are atomic](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/visibility-and-atomicity-vna/vna04-j/).

See the following references:
        [CWE-362: Concurrent Execution using Shared Resource with Improper Synchronization ('Race Condition')](https://cwe.mitre.org/data/definitions/362.html),
        [CWE-366: Race Condition within a Thread](https://cwe.mitre.org/data/definitions/366.html)
        [CWE-662: Improper Synchronization](https://cwe.mitre.org/data/definitions/662.html)