# [Method invoked that should be only be invoked inside a doPrivileged block](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DP_DO_INSIDE_DO_PRIVILEGED)

 This code invokes a method that requires a security permission check.
  If this code will be granted security permissions, but might be invoked by code that does not
  have security permissions, then the invocation needs to occur inside a doPrivileged block.