# [Unusual equals method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_UNUSUAL)

 This class doesn't do any of the patterns we recognize for checking that the type of the argument
is compatible with the type of the `this` object. There might not be anything wrong with
this code, but it is worth reviewing.