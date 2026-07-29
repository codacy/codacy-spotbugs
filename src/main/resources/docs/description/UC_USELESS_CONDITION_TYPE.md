# [Condition has no effect due to the variable type](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UC_USELESS_CONDITION_TYPE)

This condition always produces the same result due to the type range of the involved variable.
Probably something else was meant or the condition can be removed.

See [CWE-570: Expression is Always False](https://cwe.mitre.org/data/definitions/570.html)
and [CWE-571: Expression is Always True](https://cwe.mitre.org/data/definitions/571.html).