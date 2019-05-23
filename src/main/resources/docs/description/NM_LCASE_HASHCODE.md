# [Class defines hashcode(); should it be hashCode()?](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_LCASE_HASHCODE)

 This class defines a method called `hashcode()`.  This method
  does not override the `hashCode()` method in `java.lang.Object`,
  which is probably what was intended.