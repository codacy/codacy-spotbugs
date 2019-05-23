# [Method calls wait, notify or notifyAll on a Thread instance](http://fb-contrib.sourceforge.net/bugdescriptions.html#STS_SPURIOUS_THREAD_STATES)

This method invokes the methods `wait`, `notify` or `notifyAll` on a Thread instance.
			Doing so will confuse the internal thread state behavior, causing spurious thread
			wakeups/sleeps, because the internal mechanism also uses the thread instance for its
			notifications.