# [Possible null pointer dereference](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_NULL_ON_SOME_PATH)

 There is a branch of statement that, _if executed,_  guarantees that
a null value will be dereferenced, which
would generate a `NullPointerException` when the code is executed.
Of course, the problem might be that the branch or statement is infeasible and that
the null pointer exception cannot ever be executed; deciding that is beyond the ability of SpotBugs.