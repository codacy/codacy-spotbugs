# [Method call passes null for non-null parameter](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS)

      A possibly-null value is passed at a call site where all known
      target methods require the parameter to be non-null.
    Either the parameter is annotated as a parameter that should
    always be non-null, or analysis has shown that it will always be
    dereferenced.