# [Method declares unbound method template parameter(s)](http://fb-contrib.sourceforge.net/bugdescriptions.html#UMTP_UNBOUND_METHOD_TEMPLATE_PARAMETER)

This method declares a method level template parameter that is not bound by any parameter of this
			method. Therefore the template parameter adds no validation or type safety and can be removed, as it's
			just confusing to the reader.