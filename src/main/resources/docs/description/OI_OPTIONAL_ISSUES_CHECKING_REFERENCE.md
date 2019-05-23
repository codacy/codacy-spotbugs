# [Method checks an Optional reference for null](http://fb-contrib.sourceforge.net/bugdescriptions.html#OI_OPTIONAL_ISSUES_CHECKING_REFERENCE)

This method compares an Optional reference variable against null. As the whole point of the
    		Optional class is to avoid the null pointer exception, this use pattern is highly suspect.
    		The code should always make sure the Optional reference is valid, and should count on the APIs
    		of this class to check for the held reference instead.