# [Dead store to local variable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_DEAD_LOCAL_STORE)

This instruction assigns a value to a local variable,
but the value is not read or used in any subsequent instruction.
Often, this indicates an error, because the value computed is never
used.

Note that Sun's javac compiler often generates dead stores for
final local variables. Because SpotBugs is a bytecode-based tool,
there is no easy way to eliminate these false positives.