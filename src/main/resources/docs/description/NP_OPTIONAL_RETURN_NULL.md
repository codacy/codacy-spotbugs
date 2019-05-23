# [Method with Optional return type returns explicit null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_OPTIONAL_RETURN_NULL)

    The usage of Optional return type (java.util.Optional or com.google.common.base.Optional)
    always means that explicit null returns were not desired by design.
    Returning a null value in such case is a contract violation and will most likely break client code.