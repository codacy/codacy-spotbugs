# [Useless increment in return statement](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_DEAD_LOCAL_INCREMENT_IN_RETURN)

This statement has a return such as `return x++;` / `return x--;`.
A postfix increment/decrement does not impact the value of the expression,
so this increment/decrement has no effect.
Please verify that this statement does the right thing.