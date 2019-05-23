# [Possible null pointer dereference on branch that might be infeasible](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NULL_ON_SOME_PATH_MIGHT_BE_INFEASIBLE)

 There is a branch of statement that, _if executed,_  guarantees that
a null value will be dereferenced, which
would generate a `NullPointerException` when the code is executed.
Of course, the problem might be that the branch or statement is infeasible and that
the null pointer exception can't ever be executed; deciding that is beyond the ability of SpotBugs.
Due to the fact that this value had been previously tested for nullness,
this is a definite possibility.