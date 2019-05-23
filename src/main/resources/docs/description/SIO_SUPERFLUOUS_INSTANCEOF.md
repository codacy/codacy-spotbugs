# [Unnecessary type check done using instanceof operator](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SIO_SUPERFLUOUS_INSTANCEOF)

 Type check performed using the instanceof operator where it can be statically determined whether the object
is of the type requested.