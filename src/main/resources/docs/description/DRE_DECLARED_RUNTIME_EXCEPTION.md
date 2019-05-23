# [Method declares RuntimeException in throws clause](http://fb-contrib.sourceforge.net/bugdescriptions.html#DRE_DECLARED_RUNTIME_EXCEPTION)

This method declares a RuntimeException derived class in its throws clause.
			This may indicate a misunderstanding as to how unchecked exceptions are handled.
			If it is felt that a RuntimeException is so prevalent that it should be declared, it
			is probably a better idea to prevent the occurrence in code.