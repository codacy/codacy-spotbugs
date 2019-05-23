# [Creates an empty zip file entry](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#AM_CREATES_EMPTY_ZIP_FILE_ENTRY)

The code calls `putNextEntry()`, immediately
followed by a call to `closeEntry()`. This results
in an empty ZipFile entry. The contents of the entry
should be written to the ZipFile between the calls to
`putNextEntry()` and
`closeEntry()`.