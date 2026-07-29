# [Private method is never called](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UPM_UNCALLED_PRIVATE_METHOD)

 This private method is never called. Although it is
possible that the method will be invoked through reflection,
it is more likely that the method is never used, and should be
removed.

See [CWE-561: Dead Code](https://cwe.mitre.org/data/definitions/561.html).