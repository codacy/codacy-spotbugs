# [Method allocations a java.awt.Graphics object without disposing it](http://fb-contrib.sourceforge.net/bugdescriptions.html#LGO_LINGERING_GRAPHICS_OBJECT)

This method allocates a java.awt.Graphics object but doesn't dispose of it when done. While
			the garbage collector will clean this up, given that a large number of Graphics objects can be
			created in a short period of time, it is recommended that you explicitly dispose() of them.