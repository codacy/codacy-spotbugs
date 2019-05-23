# [Finalizer nulls fields](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_FINALIZER_NULLS_FIELDS)

 This finalizer nulls out fields.  This is usually an error, as it does not aid garbage collection,
  and the object is going to be garbage collected anyway.