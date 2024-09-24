# [An overridable method is called from the readObject method.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MC_OVERRIDABLE_METHOD_CALL_IN_READ_OBJECT)

      The readObject() method must not call any overridable methods. Invoking overridable methods from the readObject()
      method can provide the overriding method with access to the object's state before it is fully initialized. This
      premature access is possible because, in deserialization, readObject plays the role of object constructor and
      therefore object initialization is not complete until readObject exits.

      See SEI CERT rule [
      SER09-J. Do not invoke overridable methods from the readObject() method](https://wiki.sei.cmu.edu/confluence/display/java/SER09-J.+Do+not+invoke+overridable+methods+from+the+readObject%28%29+method).