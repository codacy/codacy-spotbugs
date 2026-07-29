# [An apparent infinite loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IL_INFINITE_LOOP)

This loop doesn't seem to have a way to terminate (other than by perhaps
throwing an exception). Unconditional loops such as `while (true) {...}` are assumed to be intentional and are not reported as bugs.

See [CWE-835: Loop with Unreachable Exit Condition ('Infinite Loop')](https://cwe.mitre.org/data/definitions/835.html).