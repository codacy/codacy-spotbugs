# [Null pointer dereference in method on exception path](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_ALWAYS_NULL_EXCEPTION)

 A pointer which is null on an exception path is dereferenced here. 
This will lead to a `NullPointerException` when the code is executed. 
Note that because SpotBugs currently does not prune infeasible exception paths,
this may be a false warning.

 Also note that SpotBugs considers the default case of a switch statement to
be an exception path, since the default case is often infeasible.