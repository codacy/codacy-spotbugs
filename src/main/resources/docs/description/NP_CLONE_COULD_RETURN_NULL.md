# [Clone method may return null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_CLONE_COULD_RETURN_NULL)

    This clone method seems to return null in some circumstances, but clone is never
    allowed to return a null value.  If you are convinced this path is unreachable, throw an AssertionError
    instead.