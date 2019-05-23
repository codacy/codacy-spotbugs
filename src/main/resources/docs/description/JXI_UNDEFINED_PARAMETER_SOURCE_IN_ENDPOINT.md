# [JAX-RS Method defines a parameter that has no @*Param or @Context annotation, or @Consumes method annotation](http://fb-contrib.sourceforge.net/bugdescriptions.html#JXI_UNDEFINED_PARAMETER_SOURCE_IN_ENDPOINT)

This JAX-RS endpoint declares a parameter without specifying where the value of this parameter comes from.
    		You can specify this by using one of several 'Param' annotations (@PathParam, @CookieParam, @FormParam @HeaderParam @MatrixParam @QueryParam),
    		by adding a @Context parameter annotation, or you can declare that the method @Consumes an XML or JSON stream.