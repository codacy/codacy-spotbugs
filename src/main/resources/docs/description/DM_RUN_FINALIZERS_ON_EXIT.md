# [Method invokes dangerous method runFinalizersOnExit](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_RUN_FINALIZERS_ON_EXIT)

 _Never call System.runFinalizersOnExit
or Runtime.runFinalizersOnExit for any reason: they are among the most
dangerous methods in the Java libraries._ -- Joshua Bloch