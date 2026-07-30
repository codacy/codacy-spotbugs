# [An apparent infinite recursive loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IL_INFINITE_RECURSIVE_LOOP)

This method unconditionally invokes itself. This would seem to indicate
an infinite recursive loop that will result in a stack overflow.

See [CWE-674: Uncontrolled Recursion](https://cwe.mitre.org/data/definitions/674.html)
and [CWE-835: Loop with Unreachable Exit Condition ('Infinite Loop')](https://cwe.mitre.org/data/definitions/835.html).