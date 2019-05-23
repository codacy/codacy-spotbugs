# [Covariant equals() method defined, Object.equals(Object) inherited](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_SELF_USE_OBJECT)

 This class defines a covariant version of the `equals()`
  method, but inherits the normal `equals(Object)` method
  defined in the base `java.lang.Object` class. 
  The class should probably define a `boolean equals(Object)` method.