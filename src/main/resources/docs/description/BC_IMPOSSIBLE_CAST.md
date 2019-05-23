# [Impossible cast](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_IMPOSSIBLE_CAST)

This cast will always throw a ClassCastException.
SpotBugs tracks type information from instanceof checks,
and also uses more precise information about the types
of values returned from methods and loaded from fields.
Thus, it may have more precise information that just
the declared type of a variable, and can use this to determine
that a cast will always throw an exception at runtime.