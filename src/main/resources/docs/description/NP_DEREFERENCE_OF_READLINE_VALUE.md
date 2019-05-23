# [Dereference of the result of readLine() without nullcheck](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_DEREFERENCE_OF_READLINE_VALUE)

 The result of invoking readLine() is dereferenced without checking to see if the result is null. If there are no more lines of text
to read, readLine() will return null and dereferencing that will generate a null pointer exception.