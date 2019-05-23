# [Method invokes inefficient new String(String) constructor](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_STRING_CTOR)

 Using the `java.lang.String(String)` constructor wastes memory
  because the object so constructed will be functionally indistinguishable
  from the `String` passed as a parameter.  Just use the
  argument `String` directly.