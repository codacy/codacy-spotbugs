# [Finalizer nullifies superclass finalizer](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_NULLIFY_SUPER)

 This empty `finalize()` method explicitly negates the
  effect of any finalizer defined by its superclass.  Any finalizer
  actions defined for the superclass will not be performed. 
  Unless this is intended, delete this method.