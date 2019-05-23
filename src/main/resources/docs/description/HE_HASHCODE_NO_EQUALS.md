# [Class defines hashCode() but not equals()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_HASHCODE_NO_EQUALS)

 This class defines a `hashCode()` method but not an
  `equals()` method.  Therefore, the class may
  violate the invariant that equal objects must have equal hashcodes.