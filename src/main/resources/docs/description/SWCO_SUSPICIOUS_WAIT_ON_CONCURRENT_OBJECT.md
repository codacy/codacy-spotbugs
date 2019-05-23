# [Method calls wait when await was probably intended](http://fb-contrib.sourceforge.net/bugdescriptions.html#SWCO_SUSPICIOUS_WAIT_ON_CONCURRENT_OBJECT)

This method calls wait() on a mutex defined in the java.util.concurrent package.
			These classes define `await`, instead of `wait`, and it is most likely that `await`
			was intended.