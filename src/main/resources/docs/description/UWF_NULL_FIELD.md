# [Field only ever set to null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UWF_NULL_FIELD)

 All writes to this field are of the constant value null, and thus
all reads of the field will return null.
Check for errors, or remove it if it is useless.