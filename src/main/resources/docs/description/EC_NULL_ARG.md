# [Call to equals(null)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EC_NULL_ARG)

 This method calls equals(Object), passing a null value as
the argument. According to the contract of the equals() method,
this call should always return `false`.

See [CWE-570: Expression is Always False](https://cwe.mitre.org/data/definitions/570.html).