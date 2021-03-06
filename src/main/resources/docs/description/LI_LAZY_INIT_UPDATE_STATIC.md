# [Incorrect lazy initialization and update of static field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#LI_LAZY_INIT_UPDATE_STATIC)

 This method contains an unsynchronized lazy initialization of a static field.
After the field is set, the object stored into that location is further updated or accessed.
The setting of the field is visible to other threads as soon as it is set. If the
further accesses in the method that set the field serve to initialize the object, then
you have a _very serious_ multithreading bug, unless something else prevents
any other thread from accessing the stored object until it is fully initialized.

Even if you feel confident that the method is never called by multiple
threads, it might be better to not set the static field until the value
you are setting it to is fully populated/initialized.