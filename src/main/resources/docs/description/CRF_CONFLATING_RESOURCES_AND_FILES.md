# [This method accesses URL resources using the File API](http://fb-contrib.sourceforge.net/bugdescriptions.html#CRF_CONFLATING_RESOURCES_AND_FILES)

This method fetches a resource from a URL, and uses the File API to manipulate it. If this resource is a
    		classpath resource, it will work if the resource is a file in a directory. If, however, the file is inside a JAR file
    		this will fail. To avoid this confusing inconsistency, use the URL.openStream API instead to access the data of the classpath resource.