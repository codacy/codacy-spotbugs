# [Class defines equals() but not hashCode()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_EQUALS_NO_HASHCODE)

 This class overrides `equals(Object)`, but does not
  override `hashCode()`.  Therefore, the class may violate the
  invariant that equal objects must have equal hashcodes.

See [CWE-581: Object Model Violation: Just One of Equals and Hashcode Defined](https://cwe.mitre.org/data/definitions/581.html).