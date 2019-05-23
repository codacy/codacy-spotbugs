# [Questionable use of non-short-circuit logic](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NS_NON_SHORT_CIRCUIT)

 This code seems to be using non-short-circuit logic (e.g., &
or |)
rather than short-circuit logic (&& or ||).
Non-short-circuit logic causes both sides of the expression
to be evaluated even when the result can be inferred from
knowing the left-hand side. This can be less efficient and
can result in errors if the left-hand side guards cases
when evaluating the right-hand side can generate an error.

See [the Java
Language Specification](https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.22.2) for details.