# [Format string should use %n rather than \n](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#VA_FORMAT_STRING_USES_NEWLINE)

This format string includes a newline character (\n). In format strings, it is generally
 preferable to use %n, which will produce the platform-specific line separator.