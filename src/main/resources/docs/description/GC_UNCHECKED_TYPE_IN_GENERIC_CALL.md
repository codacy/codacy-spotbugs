# [Unchecked type in generic call](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#GC_UNCHECKED_TYPE_IN_GENERIC_CALL)

 This call to a generic collection method passes an argument
    while compile type Object where a specific type from
    the generic type parameters is expected.
    Thus, neither the standard Java type system nor static analysis
    can provide useful information on whether the
    object being passed as a parameter is of an appropriate type.