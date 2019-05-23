# [Method modifies an http session attribute without calling setAttribute](http://fb-contrib.sourceforge.net/bugdescriptions.html#SCSS_SUSPICIOUS_CLUSTERED_SESSION_SUPPORT)

This method fetches a complex object from an HttpSession object, modifies this object, but does
			not call setAttribute, to inform the application server that this attribute has been changed. This will
			cause this attribute not to be updated in other servers in a clustered environment, as only changes marked
			by a call to setAttribute are replicated.