# [Field should be package protected](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_PKGPROTECT)

 A mutable static field could be changed by malicious code or
   by accident.
   The field could be made package protected to avoid
   this vulnerability.