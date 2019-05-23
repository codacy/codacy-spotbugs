# [Uninitialized read of field in constructor](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#UR_UNINIT_READ)

 This constructor reads a field which has not yet been assigned a value. 
  This is often caused when the programmer mistakenly uses the field instead
  of one of the constructor's parameters.