# [Method invokes System.exit(...)](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_EXIT)

 Invoking System.exit shuts down the entire Java virtual machine. This
   should only been done when it is appropriate. Such calls make it
   hard or impossible for your code to be invoked by other code.
   Consider throwing a RuntimeException instead.