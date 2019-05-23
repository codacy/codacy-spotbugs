# [Method calls keySet() just to call contains, use containsKey instead](http://fb-contrib.sourceforge.net/bugdescriptions.html#MUI_USE_CONTAINSKEY)

This method calls mySet.keySet().contains("foo") when mySet.containsKey("foo") is simpler.