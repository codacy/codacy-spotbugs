# [Method triggers finalization](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_RUNFINALIZATION)

Manually triggering finalization can result in serious performance problems and may be masking resource cleanup bugs.
			Only the garbage collector, not application code, should be concerned with finalization.