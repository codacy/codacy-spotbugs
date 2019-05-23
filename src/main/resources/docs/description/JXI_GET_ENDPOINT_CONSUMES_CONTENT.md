# [JAX-RS Method implements a GET request but consumes input](http://fb-contrib.sourceforge.net/bugdescriptions.html#JXI_GET_ENDPOINT_CONSUMES_CONTENT)

This JAX-RS endpoint is annotated to be used with @GET requests, but also documents that it
    		consumes JSON or XML data. Since a GET request pulls parameters from the URL, and not
    		the body of the request, this pattern is problematic. If you wish to consume JSON or XML data,
    		this request should be annotated with @POST.