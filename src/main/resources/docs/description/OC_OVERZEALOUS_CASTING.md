# [Method manually casts the right hand side of an assignment more specifically than needed](http://fb-contrib.sourceforge.net/bugdescriptions.html#OC_OVERZEALOUS_CASTING)

This method casts the right hand side of an expression to a class that is more specific than the
			variable on the left hand side of the assignment. The cast only has to be as specific as the variable
			that is on the left. Using a more specific type on the right hand side just increases cohesion.