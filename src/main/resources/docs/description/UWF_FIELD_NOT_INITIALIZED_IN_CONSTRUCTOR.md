# [Field not initialized in constructor but dereferenced without null check](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR)

 This field is never initialized within any constructor, and is therefore could be null after
the object is constructed. Elsewhere, it is loaded and dereferenced without a null check.
This could be a either an error or a questionable design, since
it means a null pointer exception will be generated if that field is dereferenced
before being initialized.