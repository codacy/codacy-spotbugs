# [Overwritten increment](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_OVERWRITTEN_INCREMENT)

The code performs an increment/decrement operation (e.g., `i++` / `i--`) and then
immediately overwrites it. For example, `i = i++` / `i = i--` immediately
overwrites the incremented/decremented value with the original value.

See [CWE-563: Assignment to Variable without Use](https://cwe.mitre.org/data/definitions/563.html).