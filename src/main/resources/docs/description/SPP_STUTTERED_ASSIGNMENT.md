# [Method assigns a value to a local twice in a row](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_STUTTERED_ASSIGNMENT)

This method assigns a value twice in a row in a stuttered way such as
			`a = a = 5;` This is most probably a cut and paste error where the duplicate
			assignment can be removed.