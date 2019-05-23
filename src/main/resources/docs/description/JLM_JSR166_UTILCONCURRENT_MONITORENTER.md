# [Synchronization performed on util.concurrent instance](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#JLM_JSR166_UTILCONCURRENT_MONITORENTER)

 This method performs synchronization an object that is an instance of
a class from the java.util.concurrent package (or its subclasses). Instances
of these classes have their own concurrency control mechanisms that are orthogonal to
the synchronization provided by the Java keyword `synchronized`. For example,
synchronizing on an `AtomicBoolean` will not prevent other threads
from modifying the  `AtomicBoolean`.

Such code may be correct, but should be carefully reviewed and documented,
and may confuse people who have to maintain the code at a later date.