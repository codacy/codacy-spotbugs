# [Method ignores results of InputStream.skip()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SR_NOT_CHECKED)

 This method ignores the return value of
  `java.io.InputStream.skip()` which can skip multiple bytes. 
  If the return value is not checked, the caller will not be able to correctly
  handle the case where fewer bytes were skipped than the caller requested. 
  This is a particularly insidious kind of bug, because in many programs,
  skips from input streams usually do skip the full amount of data requested,
  causing the program to fail only sporadically. With Buffered streams, however,
  skip() will only skip data in the buffer, and will routinely fail to skip the
  requested number of bytes.