# [File.separator used for regular expression](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RE_CANT_USE_FILE_SEPARATOR_AS_REGULAR_EXPRESSION)

The code here uses `File.separator`
where a regular expression is required. This will fail on Windows
platforms, where the `File.separator` is a backslash, which is interpreted in a
regular expression as an escape character. Among other options, you can just use
`File.separatorChar=='\\' ? "\\\\" : File.separator` instead of
`File.separator`