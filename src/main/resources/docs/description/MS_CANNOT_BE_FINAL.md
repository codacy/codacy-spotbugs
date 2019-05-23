# [Field isn't final and can't be protected from malicious code](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_CANNOT_BE_FINAL)

 A mutable static field could be changed by malicious code or
        by accident from another package.
   Unfortunately, the way the field is used doesn't allow
   any easy fix to this problem.