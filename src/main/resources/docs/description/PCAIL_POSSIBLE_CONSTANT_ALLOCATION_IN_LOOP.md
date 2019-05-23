# [Method allocates an object that is used in a constant way in a loop](http://fb-contrib.sourceforge.net/bugdescriptions.html#PCAIL_POSSIBLE_CONSTANT_ALLOCATION_IN_LOOP)

This method allocates an object using the default constructor in a loop, and then
			only uses it in a quasi-static way. It is never assigned to anything that lives outside
			the loop, and could potentially be allocated once outside the loop. Often this can be
			achieved by calling a clear() like method in the loop, to reset the state of the object
			in the loop.