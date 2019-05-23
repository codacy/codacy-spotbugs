# [Dead store due to switch statement fall through to throw](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SF_DEAD_STORE_DUE_TO_SWITCH_FALLTHROUGH_TO_THROW)

 A value stored in the previous switch case is ignored here due to a switch fall through to a place where
    an exception is thrown. It is likely that
    you forgot to put a break or return at the end of the previous case.