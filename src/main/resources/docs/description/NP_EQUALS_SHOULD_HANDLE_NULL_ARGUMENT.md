# [equals() method does not check for null argument](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NP_EQUALS_SHOULD_HANDLE_NULL_ARGUMENT)

      This implementation of equals(Object) violates the contract defined
      by java.lang.Object.equals() because it does not check for null
      being passed as the argument.  All equals() methods should return
      false if passed a null value.