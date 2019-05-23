# [Finalizer does not call superclass finalizer](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_MISSING_SUPER_CALL)

 This `finalize()` method does not make a call to its
  superclass's `finalize()` method.  So, any finalizer
  actions defined for the superclass will not be performed. 
  Add a call to `super.finalize()`.