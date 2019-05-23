# [Wait with two locks held](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#TLW_TWO_LOCK_WAIT)

 Waiting on a monitor while two locks are held may cause
  deadlock.
    
   Performing a wait only releases the lock on the object
   being waited on, not any other locks.
    
This not necessarily a bug, but is worth examining
  closely.