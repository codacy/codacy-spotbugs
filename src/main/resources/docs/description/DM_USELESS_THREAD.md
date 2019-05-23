# [A thread was created using the default empty run method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_USELESS_THREAD)

This method creates a thread without specifying a run method either by deriving from the Thread class, or
  by passing a Runnable object. This thread, then, does nothing but waste time.