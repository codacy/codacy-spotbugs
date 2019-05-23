# [Method calls prepareStatement in a loop](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IIL_PREPARE_STATEMENT_IN_LOOP)

 The method calls Connection.prepareStatement inside the loop passing the constant arguments.
If the PreparedStatement should be executed several times there's no reason to recreate it for each loop iteration.
Move this call outside of the loop.