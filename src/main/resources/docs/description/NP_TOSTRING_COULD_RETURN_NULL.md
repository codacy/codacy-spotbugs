# [toString method may return null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_TOSTRING_COULD_RETURN_NULL)

    This toString method seems to return null in some circumstances. A liberal reading of the
    spec could be interpreted as allowing this, but it is probably a bad idea and could cause
    other code to break. Return the empty string or some other appropriate string rather than null.