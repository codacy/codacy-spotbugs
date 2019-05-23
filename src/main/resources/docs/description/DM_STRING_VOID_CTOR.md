# [Method invokes inefficient new String() constructor](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_STRING_VOID_CTOR)

 Creating a new `java.lang.String` object using the
  no-argument constructor wastes memory because the object so created will
  be functionally indistinguishable from the empty string constant
  `""`.  Java guarantees that identical string constants
  will be represented by the same `String` object.  Therefore,
  you should just use the empty string constant directly.