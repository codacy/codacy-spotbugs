# [A known null value is checked to see if it is an instance of a type](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_NULL_INSTANCEOF)

This instanceof test will always return false, since the value being checked is guaranteed to be null.
Although this is safe, make sure it isn't
an indication of some misunderstanding or some other logic error.