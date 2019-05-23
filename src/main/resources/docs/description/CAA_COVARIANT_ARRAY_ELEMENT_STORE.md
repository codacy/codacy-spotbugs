# [Possibly incompatible element is stored in covariant array](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CAA_COVARIANT_ARRAY_ELEMENT_STORE)

Value is stored into the array and the value type doesn't match the array type.
It's known from the analysis that actual array type is narrower than the declared type of its variable or field
and this assignment doesn't satisfy the original array type. This assignment may cause ArrayStoreException
at runtime.