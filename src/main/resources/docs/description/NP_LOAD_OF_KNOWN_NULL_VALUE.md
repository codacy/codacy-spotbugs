# [Load of known null value](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_LOAD_OF_KNOWN_NULL_VALUE)

 The variable referenced at this point is known to be null due to an earlier
   check against null. Although this is valid, it might be a mistake (perhaps you
intended to refer to a different variable, or perhaps the earlier check to see if the
variable is null should have been a check to see if it was non-null).