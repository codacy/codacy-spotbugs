# [Class exposes synchronization and semaphores in its public interface](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PS_PUBLIC_SEMAPHORES)

    This class uses synchronization along with wait(), notify() or notifyAll() on itself (the this
    reference). Client classes that use this class, may, in addition, use an instance of this class
    as a synchronizing object. Because two classes are using the same object for synchronization,
    Multithread correctness is suspect. You should not synchronize nor call semaphore methods on
    a public reference. Consider using an internal private member variable to control synchronization.