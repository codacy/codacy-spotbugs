# [Method uses the same HttpSession attribute name but with different casing](http://fb-contrib.sourceforge.net/bugdescriptions.html#IKNC_INCONSISTENT_HTTP_ATTRIBUTE_CASING)

This method sets or gets an HttpSession attribute with a parameter name that was used in other locations
			but with a different casing. As HttpSession attribute are case-sensitive, this will be very confusing.