# [Constructor invokes Thread.start()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SC_START_IN_CTOR)

 The constructor starts a thread. This is likely to be wrong if
   the class is ever extended/subclassed, since the thread will be started
   before the subclass constructor is started.