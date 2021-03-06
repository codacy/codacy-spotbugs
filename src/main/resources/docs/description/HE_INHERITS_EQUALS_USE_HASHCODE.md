# [Class inherits equals() and uses Object.hashCode()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_INHERITS_EQUALS_USE_HASHCODE)

 This class inherits `equals(Object)` from an abstract
  superclass, and `hashCode()` from
`java.lang.Object` (which returns
  the identity hash code, an arbitrary value assigned to the object
  by the VM).  Therefore, the class is very likely to violate the
  invariant that equal objects must have equal hashcodes.

If you don't want to define a hashCode method, and/or don't
   believe the object will ever be put into a HashMap/Hashtable,
   define the `hashCode()` method
   to throw `UnsupportedOperationException`.