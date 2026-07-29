# [Empty finalizer should be deleted](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_EMPTY)

 Empty `finalize()` methods are useless, so they should
  be deleted.

See [CWE-568: finalize() Method Without super.finalize()](https://cwe.mitre.org/data/definitions/568.html).