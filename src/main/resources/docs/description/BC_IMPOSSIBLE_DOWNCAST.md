# [Impossible downcast](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_IMPOSSIBLE_DOWNCAST)

This cast will always throw a ClassCastException.
The analysis believes it knows
the precise type of the value being cast, and the attempt to
downcast it to a subtype will always fail by throwing a ClassCastException.