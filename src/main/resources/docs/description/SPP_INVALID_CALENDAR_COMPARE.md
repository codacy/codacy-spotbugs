# [Method passes a non calendar object to Calendar.before or Calendar.after](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_INVALID_CALENDAR_COMPARE)

This method passes a non-calendar object to the java.util.Calendar.after or java.util.Calendar.before methods.
			Even though these methods take an Object as a parameter type, only Calendar type objects are supported, otherwise
			false is returned.