# [Method with Boolean return type returns explicit null](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_BOOLEAN_RETURN_NULL)

    A method that returns either Boolean.TRUE, Boolean.FALSE or null is an accident waiting to happen.
    This method can be invoked as though it returned a value of type boolean, and
    the compiler will insert automatic unboxing of the Boolean value. If a null value is returned,
    this will result in a NullPointerException.