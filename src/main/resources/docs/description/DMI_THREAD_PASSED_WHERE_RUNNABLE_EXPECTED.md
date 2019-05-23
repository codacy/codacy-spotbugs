# [Thread passed where Runnable expected](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_THREAD_PASSED_WHERE_RUNNABLE_EXPECTED)

 A Thread object is passed as a parameter to a method where
a Runnable is expected. This is rather unusual, and may indicate a logic error
or cause unexpected behavior.