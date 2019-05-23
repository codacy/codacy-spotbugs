# [Reversed method arguments](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_ARGUMENTS_WRONG_ORDER)

 The arguments to this method call seem to be in the wrong order.
For example, a call `Preconditions.checkNotNull("message", message)`
has reserved arguments: the value to be checked is the first argument.