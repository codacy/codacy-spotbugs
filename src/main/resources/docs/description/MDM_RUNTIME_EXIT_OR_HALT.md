# [Method calls Runtime.exit() or Runtime.halt()](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_RUNTIME_EXIT_OR_HALT)

Calling `Runtime.exit()` or `Runtime.halt()` shuts down the entire Java virtual machine.
			This should only be done in very rare circumstances. Such calls make it hard or impossible for your code to be
			invoked by other code. Consider throwing a RuntimeException instead.