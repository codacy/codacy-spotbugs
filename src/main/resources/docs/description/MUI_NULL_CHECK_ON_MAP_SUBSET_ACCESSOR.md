# [Method checks whether the keySet(), entrySet() or values() collection of a Map is null](http://fb-contrib.sourceforge.net/bugdescriptions.html#MUI_NULL_CHECK_ON_MAP_SUBSET_ACCESSOR)

			This method checks to see if the return value from a keySet(), entrySet() or values() method call on a Map is null.
			For any valid functioning Map these collections will always be non-null, and so the call is superfluous. Maybe you intended
			to check whether those sets were empty instead.