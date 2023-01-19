# [Method invokes inefficient floating-point Number constructor; use static valueOf instead](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_FP_NUMBER_CTOR)

      Using `new Double(double)` is guaranteed to always result in a new object whereas
      `Double.valueOf(double)` allows caching of values to be done by the compiler, class library, or JVM.
      Using of cached values avoids object allocation and the code will be faster.

      Unless the class must be compatible with JVMs predating Java 5,
      use either autoboxing or the `valueOf()` method when creating instances of `Double` and `Float`.