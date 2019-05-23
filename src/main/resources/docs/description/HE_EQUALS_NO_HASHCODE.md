# [Class defines equals() but not hashCode()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_EQUALS_NO_HASHCODE)

 This class overrides `equals(Object)`, but does not
  override `hashCode()`.  Therefore, the class may violate the
  invariant that equal objects must have equal hashcodes.