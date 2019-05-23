# [Field should be both final and package protected](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_FINAL_PKGPROTECT)

   A mutable static field could be changed by malicious code or
        by accident from another package.
        The field could be made package protected and/or made final
   to avoid
        this vulnerability.