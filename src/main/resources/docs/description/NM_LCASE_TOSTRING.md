# [Class defines tostring(); should it be toString()?](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_LCASE_TOSTRING)

 This class defines a method called `tostring()`.  This method
  does not override the `toString()` method in `java.lang.Object`,
  which is probably what was intended.