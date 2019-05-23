# [Abstract class defines covariant compareTo() method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CO_ABSTRACT_SELF)

 This class defines a covariant version of `compareTo()`. 
  To correctly override the `compareTo()` method in the
  `Comparable` interface, the parameter of `compareTo()`
  must have type `java.lang.Object`.