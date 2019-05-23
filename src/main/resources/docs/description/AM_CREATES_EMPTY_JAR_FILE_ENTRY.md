# [Creates an empty jar file entry](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AM_CREATES_EMPTY_JAR_FILE_ENTRY)

The code calls `putNextEntry()`, immediately
followed by a call to `closeEntry()`. This results
in an empty JarFile entry. The contents of the entry
should be written to the JarFile between the calls to
`putNextEntry()` and
`closeEntry()`.