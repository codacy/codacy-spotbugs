# [Method invokes inefficient Boolean constructor; use Boolean.valueOf(...) instead](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_BOOLEAN_CTOR)

 Creating new instances of `java.lang.Boolean` wastes
  memory, since `Boolean` objects are immutable and there are
  only two useful values of this type.  Use the `Boolean.valueOf()`
  method (or Java 5 autoboxing) to create `Boolean` objects instead.