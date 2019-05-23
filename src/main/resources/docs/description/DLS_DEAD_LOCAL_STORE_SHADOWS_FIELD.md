# [Dead store to local variable that shadows field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_DEAD_LOCAL_STORE_SHADOWS_FIELD)

This instruction assigns a value to a local variable,
but the value is not read or used in any subsequent instruction.
Often, this indicates an error, because the value computed is never
used. There is a field with the same name as the local variable. Did you
mean to assign to that variable instead?