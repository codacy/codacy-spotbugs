# [Finalizer only nulls fields](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_FINALIZER_ONLY_NULLS_FIELDS)

 This finalizer does nothing except null out fields. This is completely pointless, and requires that
the object be garbage collected, finalized, and then garbage collected again. You should just remove the finalize
method.