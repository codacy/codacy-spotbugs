# [Dead store due to switch statement fall through](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SF_DEAD_STORE_DUE_TO_SWITCH_FALLTHROUGH)

 A value stored in the previous switch case is overwritten here due to a switch fall through. It is likely that
    you forgot to put a break or return at the end of the previous case.