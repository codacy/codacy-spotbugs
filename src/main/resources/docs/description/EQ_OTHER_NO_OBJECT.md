# [equals() method defined that doesn't override equals(Object)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_OTHER_NO_OBJECT)

 This class defines an `equals()`
  method, that doesn't override the normal `equals(Object)` method
  defined in the base `java.lang.Object` class.  Instead, it
  inherits an `equals(Object)` method from a superclass.
  The class should probably define a `boolean equals(Object)` method.