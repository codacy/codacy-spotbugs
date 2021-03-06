# [Class's readObject() method is synchronized](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RS_READOBJECT_SYNC)

 This serializable class defines a `readObject()` which is
  synchronized.  By definition, an object created by deserialization
  is only reachable by one thread, and thus there is no need for
  `readObject()` to be synchronized.  If the `readObject()`
  method itself is causing the object to become visible to another thread,
  that is an example of very dubious coding style.