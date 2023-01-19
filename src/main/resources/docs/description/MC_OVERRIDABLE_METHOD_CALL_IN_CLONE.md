# [An overridable method is called from the clone() method.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MC_OVERRIDABLE_METHOD_CALL_IN_CLONE)

      Calling overridable methods from the clone() method is insecure because a subclass could override the method,
      affecting the behavior of clone(). It can also observe or modify the clone object in a partially initialized
      state. Only static, final or private methods should be invoked from the clone() method.

      See SEI CERT rule
      [MET06-J. Do not invoke overridable methods in clone()](https://wiki.sei.cmu.edu/confluence/pages/viewpage.action?pageId=88487921).