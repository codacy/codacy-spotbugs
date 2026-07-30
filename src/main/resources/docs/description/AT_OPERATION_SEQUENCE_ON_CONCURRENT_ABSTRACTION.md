# [Sequence of calls to concurrent abstraction may not be atomic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AT_OPERATION_SEQUENCE_ON_CONCURRENT_ABSTRACTION)

This code contains a sequence of calls to a concurrent  abstraction
            (such as a concurrent hash map).
            These calls will not be executed atomically.

See the following references:
            [CWE-362: Concurrent Execution using Shared Resource with Improper Synchronization ('Race Condition')](https://cwe.mitre.org/data/definitions/362.html),
            [CWE-366: Race Condition within a Thread](https://cwe.mitre.org/data/definitions/366.html)
            [CWE-662: Improper Synchronization](https://cwe.mitre.org/data/definitions/662.html)