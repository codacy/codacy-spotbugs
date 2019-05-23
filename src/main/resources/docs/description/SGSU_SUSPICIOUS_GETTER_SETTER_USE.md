# [Method uses same bean's getter value for setter](http://fb-contrib.sourceforge.net/bugdescriptions.html#SGSU_SUSPICIOUS_GETTER_SETTER_USE)

This method retrieves the property of a Java bean, only to use it in the setter
			for the same property of the same bean. This is usually a copy/paste typo.