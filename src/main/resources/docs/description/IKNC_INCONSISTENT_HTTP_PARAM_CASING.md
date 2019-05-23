# [Method uses the same HttpRequest parameter name but with different casing](http://fb-contrib.sourceforge.net/bugdescriptions.html#IKNC_INCONSISTENT_HTTP_PARAM_CASING)

This method fetches an HttpServletRequest parameter with a parameter name that was used in other locations
			but with a different casing. As HttpServletRequest parameters are case-sensitive, this will be very confusing.