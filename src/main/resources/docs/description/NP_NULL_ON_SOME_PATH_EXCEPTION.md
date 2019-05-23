# [Possible null pointer dereference in method on exception path](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NULL_ON_SOME_PATH_EXCEPTION)

 A reference value which is null on some exception control path is
dereferenced here.  This may lead to a `NullPointerException`
when the code is executed. 
Note that because SpotBugs currently does not prune infeasible exception paths,
this may be a false warning.

 Also note that SpotBugs considers the default case of a switch statement to
be an exception path, since the default case is often infeasible.