# [Method defines a variable that obscures a field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MF_METHOD_MASKS_FIELD)

 This method defines a local variable with the same name as a field
in this class or a superclass.  This may cause the method to
read an uninitialized value from the field, leave the field uninitialized,
or both.