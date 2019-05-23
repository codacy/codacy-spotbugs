# [Vacuous call to collections](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_VACUOUS_SELF_COLLECTION_CALL)

 This call doesn't make sense. For any collection `c`, calling `c.containsAll(c)` should
always be true, and `c.retainAll(c)` should have no effect.