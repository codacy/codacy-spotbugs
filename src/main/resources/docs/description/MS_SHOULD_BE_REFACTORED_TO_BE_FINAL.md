# [Field isn't final but should be refactored to be so](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_SHOULD_BE_REFACTORED_TO_BE_FINAL)

This `public static` or `protected static` field is not final, and
could be changed by malicious code or
by accident from another package.
The field could be made final to avoid
this vulnerability. However, the static initializer contains more than one write
to the field, so doing so will require some refactoring.