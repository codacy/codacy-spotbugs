# [Notify with two locks held](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TLW_TWO_LOCK_NOTIFY)

 The code calls notify() or notifyAll() while two locks
  are held. If this notification is intended to wake up a wait()
  that is holding the same locks, it may deadlock, since the wait
  will only give up one lock and the notify will be unable to get both locks,
  and thus the notify will not succeed.
     If there is also a warning about a two lock wait, the
   probability of a bug is quite high.