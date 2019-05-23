# [Covariant array assignment to a field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CAA_COVARIANT_ARRAY_FIELD)

Array of covariant type is assigned to a field. This is confusing and may lead to ArrayStoreException at runtime
if the reference of some other type will be stored in this array later like in the following code:

    Number[] arr = new Integer[10];
    arr[0] = 1.0;

Consider changing the type of created array or the field type.