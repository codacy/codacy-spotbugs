# [Private readResolve method not inherited by subclasses](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_PRIVATE_READ_RESOLVE_NOT_INHERITED)

 This class defines a private readResolve method. Since it is private, it won't be inherited by subclasses.
This might be intentional and OK, but should be reviewed to ensure it is what is intended.