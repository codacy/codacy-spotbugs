# [Method call passes null to a non-null parameter](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NONNULL_PARAM_VIOLATION)

      This method passes a null value as the parameter of a method which
    must be non-null. Either this parameter has been explicitly marked
    as @Nonnull, or analysis has determined that this parameter is
    always dereferenced.