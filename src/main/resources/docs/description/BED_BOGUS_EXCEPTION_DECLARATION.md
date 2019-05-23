# [Non derivable method declares throwing an exception that isn't thrown](http://fb-contrib.sourceforge.net/bugdescriptions.html#BED_BOGUS_EXCEPTION_DECLARATION)

This method declares that it throws a checked exception that it does not throw. As this method is
			either a constructor, static method or private method, there is no reason for this method to declare
			the exception in its throws clause, and just causes calling methods to unnecessarily handle an exception
			that will never be thrown. The exception in question should be removed from the throws clause.