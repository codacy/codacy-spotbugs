# [Boxing a primitive to compare](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_BOXED_PRIMITIVE_FOR_COMPARE)

A boxed primitive is created just to call `compareTo()` method. It's more efficient to use static compare method
  (for double and float since Java 1.4, for other primitive types since Java 7) which works on primitives directly.