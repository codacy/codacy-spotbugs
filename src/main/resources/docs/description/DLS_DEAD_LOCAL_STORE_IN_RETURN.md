# [Useless assignment in return statement](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_DEAD_LOCAL_STORE_IN_RETURN)

This statement assigns to a local variable in a return statement. This assignment
has no effect. Please verify that this statement does the right thing.