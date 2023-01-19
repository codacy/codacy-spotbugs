# [Instance level lock was used on a shared static data](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SSD_DO_NOT_USE_INSTANCE_LOCK_ON_SHARED_STATIC_DATA)

        If the lock or the synchronized method is not static, that modifies the static field,
        that could leave the shared static data unprotected against concurrent access.
        This could occur in two ways, if a synchronization method uses a non-static lock object,
        or a synchronized method is declared as non-static. Both ways are ineffective.
        Best solution is to use a private static final lock object to secure the shared static data.

      See SEI CERT rule
      [
      LCK06-J. Do not use an instance lock to protect shared static data](https://wiki.sei.cmu.edu/confluence/display/java/LCK06-J.+Do+not+use+an+instance+lock+to+protect+shared+static+data).