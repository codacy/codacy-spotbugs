# [Nonsensical self computation involving a variable (e.g., x & x)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SA_LOCAL_SELF_COMPUTATION)

 This method performs a nonsensical computation of a local variable with another
reference to the same variable (e.g., x&x or x-x). Because of the nature
of the computation, this operation doesn't seem to make sense,
and may indicate a typo or
a logic error.  Double check the computation.