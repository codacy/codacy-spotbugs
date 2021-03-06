# [Inconsistent synchronization](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IS2_INCONSISTENT_SYNC)

 The fields of this class appear to be accessed inconsistently with respect
  to synchronization.  This bug report indicates that the bug pattern detector
  judged that

*   The class contains a mix of locked and unlocked accesses,
*   The class is **not** annotated as javax.annotation.concurrent.NotThreadSafe,
*   At least one locked access was performed by one of the class's own methods, and
*   The number of unsynchronized field accesses (reads and writes) was no more than
           one third of all accesses, with writes being weighed twice as high as reads

 A typical bug matching this bug pattern is forgetting to synchronize
  one of the methods in a class that is intended to be thread-safe.

 You can select the nodes labeled "Unsynchronized access" to show the
  code locations where the detector believed that a field was accessed
  without synchronization.

 Note that there are various sources of inaccuracy in this detector;
  for example, the detector cannot statically detect all situations in which
  a lock is held.  Also, even when the detector is accurate in
  distinguishing locked vs. unlocked accesses, the code in question may still
  be correct.