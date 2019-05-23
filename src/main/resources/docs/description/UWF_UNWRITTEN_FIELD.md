# [Unwritten field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UWF_UNWRITTEN_FIELD)

 This field is never written.  All reads of it will return the default
value. Check for errors (should it have been initialized?), or remove it if it is useless.