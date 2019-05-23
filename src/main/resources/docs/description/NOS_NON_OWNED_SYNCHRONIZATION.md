# [Class uses non owned variables to synchronize on](http://fb-contrib.sourceforge.net/bugdescriptions.html#NOS_NON_OWNED_SYNCHRONIZATION)

This method uses a synchronize block where the object that is being synchronized on,
			is not owned by this current instance. This means that other instances may use this same
			object for synchronization for their own purposes, causing synchronization confusion. It is
			always cleaner and safer to only synchronize on private fields of this class. Note that 'this'
			is not owned by the current instance, but is owned by whomever assigns it to a field of its
			class. Synchronizing on 'this' is also not a good idea.