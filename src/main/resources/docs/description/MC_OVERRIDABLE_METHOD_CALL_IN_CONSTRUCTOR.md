# [An overridable method is called from a constructor](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MC_OVERRIDABLE_METHOD_CALL_IN_CONSTRUCTOR)

      Calling an overridable method during in a constructor may result in the use of uninitialized data. It may also
      leak the this reference of the partially constructed object. Only static, final or private methods should be
      invoked from a constructor.

      See SEI CERT rule [MET05-J. Ensure that constructors do not call overridable methods](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/methods-met/met05-j/).