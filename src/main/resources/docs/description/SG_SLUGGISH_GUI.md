# [Method performs time consuming operation in GUI thread](http://fb-contrib.sourceforge.net/bugdescriptions.html#SG_SLUGGISH_GUI)

This method implements an AWT or Swing listener and performs time
			consuming operations. Doing these operations in the GUI thread will cause the
			interface to appear sluggish and non-responsive to the user. Consider
			using a separate thread to do the time consuming work so that the user
			has a better experience.