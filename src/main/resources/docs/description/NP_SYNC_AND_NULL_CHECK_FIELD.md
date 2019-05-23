# [Synchronize and null check on the same field.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_SYNC_AND_NULL_CHECK_FIELD)

Since the field is synchronized on, it seems not likely to be null.
If it is null and then synchronized on a NullPointerException will be
thrown and the check would be pointless. Better to synchronize on
another field.