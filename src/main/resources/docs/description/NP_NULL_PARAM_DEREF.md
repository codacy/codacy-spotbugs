# [Method call passes null for non-null parameter](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NULL_PARAM_DEREF)

      This method call passes a null value for a non-null method parameter.
    Either the parameter is annotated as a parameter that should
    always be non-null, or analysis has shown that it will always be
    dereferenced.