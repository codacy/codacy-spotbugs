# [Apparent method/constructor confusion](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_METHOD_CONSTRUCTOR_CONFUSION)

 This regular method has the same name as the class it is defined in. It is likely that this was intended to be a constructor.
      If it was intended to be a constructor, remove the declaration of a void return value.
    If you had accidentally defined this method, realized the mistake, defined a proper constructor
    but cannot get rid of this method due to backwards compatibility, deprecate the method.