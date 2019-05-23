# [Finalizer does nothing but call superclass finalizer](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#FI_USELESS)

 The only thing this `finalize()` method does is call
  the superclass's `finalize()` method, making it
  redundant.  Delete it.