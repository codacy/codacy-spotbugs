# [Class defines equals() and uses Object.hashCode()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_EQUALS_USE_HASHCODE)

 This class overrides `equals(Object)`, but does not
  override `hashCode()`, and inherits the implementation of
  `hashCode()` from `java.lang.Object` (which returns
  the identity hash code, an arbitrary value assigned to the object
  by the VM).  Therefore, the class is very likely to violate the
  invariant that equal objects must have equal hashcodes.

If you don't think instances of this class will ever be inserted into a HashMap/HashTable,
the recommended `hashCode` implementation to use is:

    public int hashCode() {
        assert false : "hashCode not designed";
        return 42; // any arbitrary constant will do
    }