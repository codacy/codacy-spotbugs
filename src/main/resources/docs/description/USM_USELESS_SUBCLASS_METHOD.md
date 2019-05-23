# [Method superfluously delegates to parent class method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#USM_USELESS_SUBCLASS_METHOD)

      This derived method merely calls the same superclass method passing in the exact parameters
      received. This method can be removed, as it provides no additional value.