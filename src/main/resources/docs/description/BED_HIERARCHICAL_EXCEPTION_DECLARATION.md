# [Method declares throwing two or more exceptions related by inheritance](http://fb-contrib.sourceforge.net/bugdescriptions.html#BED_HIERARCHICAL_EXCEPTION_DECLARATION)

This method declares that it throws an exception that is the child of another exception that is
			also declared to be thrown. Given that the parent exception is declared, there is no need for the child
			exception to also be declared; it just adds confusion.