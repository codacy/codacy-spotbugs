# [Method invokes inefficient Number constructor; use static valueOf instead](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_NUMBER_CTOR)

      Using `new Integer(int)` is guaranteed to always result in a new object whereas
      `Integer.valueOf(int)` allows caching of values to be done by the compiler, class library, or JVM.
      Using of cached values avoids object allocation and the code will be faster.

      Values between -128 and 127 are guaranteed to have corresponding cached instances
      and using `valueOf` is approximately 3.5 times faster than using constructor.
      For values outside the constant range the performance of both styles is the same.

      Unless the class must be compatible with JVMs predating Java 5,
      use either autoboxing or the `valueOf()` method when creating instances of
      `Long`, `Integer`, `Short`, `Character`, and `Byte`.