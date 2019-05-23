# [Unwritten public or protected field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD)

 No writes were seen to this public/protected field.  All reads of it will return the default
value. Check for errors (should it have been initialized?), or remove it if it is useless.