# [JAX-RS Method specifies an invalid @Context parameter type](http://fb-contrib.sourceforge.net/bugdescriptions.html#JXI_INVALID_CONTEXT_PARAMETER_TYPE)

This JAX-RS endpoint annotates a parameter with a @Context annotation. This annotation can supply values
    		for the following types:

*   javax.ws.rs.core.UriInfo
*   javax.ws.rs.core.HttpHeaders
*   javax.ws.rs.core.Request
*   javax.ws.rs.core.SecurityContext
*   javax.ws.rs.ext.Providers
*   javax.servlet.ServletConfig
*   javax.servlet.ServletContext
*   javax.servlet.HttpServletRequest
*   javax.servlet.HttpServletResponse

		    It is possible that your container can supply additional types, but these types are not standard and may
		    not be supported on other application servers.