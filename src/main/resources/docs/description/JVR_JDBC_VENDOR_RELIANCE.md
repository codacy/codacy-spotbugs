# [Method uses JDBC vendor specific classes and methods](http://fb-contrib.sourceforge.net/bugdescriptions.html#JVR_JDBC_VENDOR_RELIANCE)

This method uses JDBC vendor-specific classes and methods to perform database work.
			This makes the code specific to this vendor, and unable to run on other databases.