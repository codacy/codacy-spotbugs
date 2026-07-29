# [Using pointer equality to compare different types](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EC_UNRELATED_TYPES_USING_POINTER_EQUALITY)

 This method uses pointer equality to compare two references that seem to be of
different types. The result of this comparison will always be false at runtime.

See [CWE-570: Expression is Always False](https://cwe.mitre.org/data/definitions/570.html).