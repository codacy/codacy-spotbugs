# [Finalizer should be protected, not public](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_PUBLIC_SHOULD_BE_PROTECTED)

 A class's `finalize()` method should have protected access,
   not public.

See [CWE-583: finalize() Method Declared Public](https://cwe.mitre.org/data/definitions/583.html).