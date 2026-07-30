# [Class defines hashCode() but not equals()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_HASHCODE_NO_EQUALS)

 This class defines a `hashCode()` method but not an
  `equals()` method.  Therefore, the class may
  violate the invariant that equal objects must have equal hashcodes.

See [CWE-581: Object Model Violation: Just One of Equals and Hashcode Defined](https://cwe.mitre.org/data/definitions/581.html).