# [Method ignores results of InputStream.read()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RR_NOT_CHECKED)

 This method ignores the return value of one of the variants of
  `java.io.InputStream.read()` which can return multiple bytes. 
  If the return value is not checked, the caller will not be able to correctly
  handle the case where fewer bytes were read than the caller requested. 
  This is a particularly insidious kind of bug, because in many programs,
  reads from input streams usually do read the full amount of data requested,
  causing the program to fail only sporadically.

See [CWE-252: Unchecked Return Value](https://cwe.mitre.org/data/definitions/252.html).

Additionally, it is not sufficient to simply check for the end of the file (EOF)
  as an indicator that the entire array has been filled. The return value of
  `read()` must be verified to ensure that the correct number of bytes
  have been read.