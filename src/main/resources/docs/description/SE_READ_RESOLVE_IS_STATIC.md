# [The readResolve method must not be declared as a static method.  ](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_READ_RESOLVE_IS_STATIC)

 In order for the readResolve method to be recognized by the serialization
mechanism, it must not be declared as a static method.