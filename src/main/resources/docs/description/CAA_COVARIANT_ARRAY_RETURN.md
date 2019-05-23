# [Covariant array is returned from the method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CAA_COVARIANT_ARRAY_RETURN)

Array of covariant type is returned from the method. This is confusing and may lead to ArrayStoreException at runtime
if the calling code will try to store the reference of some other type in the returned array.

Consider changing the type of created array or the method return type.