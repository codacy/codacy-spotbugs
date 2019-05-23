# [Method synchronizes on an updated field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ML_SYNC_ON_UPDATED_FIELD)

 This method synchronizes on an object
   referenced from a mutable field.
   This is unlikely to have useful semantics, since different
threads may be synchronizing on different objects.