# [Method converts StringBuffer or Builder to String just to get its length](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_STRINGBUILDER_LENGTH)

This method calls the toString method on a StringBuffer or StringBuilder, only to call length() on the resulting
			string. It is faster, and less memory intensive, to just call the length method directly on the StringBuffer or StringBuilder
			itself.