# [Sequence of calls to concurrent abstraction may not be atomic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AT_OPERATION_SEQUENCE_ON_CONCURRENT_ABSTRACTION)

This code contains a sequence of calls to a concurrent  abstraction
            (such as a concurrent hash map).
            These calls will not be executed atomically.