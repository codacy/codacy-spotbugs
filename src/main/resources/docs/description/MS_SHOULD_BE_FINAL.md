# [Field isn't final but should be](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_SHOULD_BE_FINAL)

This static field public but not final, and
could be changed by malicious code or
        by accident from another package.
        The field could be made final to avoid
        this vulnerability.