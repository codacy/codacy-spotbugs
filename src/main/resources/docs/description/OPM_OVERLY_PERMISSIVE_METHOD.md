# [This method is declared more permissively than is used in the code base](http://fb-contrib.sourceforge.net/bugdescriptions.html#OPM_OVERLY_PERMISSIVE_METHOD)

This method is declared more permissively than the code is using. Having this method be more
			permissive than is needed limits your ability to make observations about this method, like
    		parameter usage, refactorability, and derivability. It is possible that this detector will report
    		erroneously if:

*   The method is called from code not being scanned, such as unit tests
*   The method is an API method, expected to be used by unknown client code
*   The method is called through reflection