# [Method does not define a parameter as final, but could](http://fb-contrib.sourceforge.net/bugdescriptions.html#FP_FINAL_PARAMETERS)

This method does not write to a parameter. To help document this, and to perhaps
			help the JVM optimize the invocation of this method, you should consider defining these parameters
			as final.

Performance gains are debatable as "the final keyword does not appear in the class file for
			local variables and parameters, thus it cannot impact the runtime performance. Its only use
			is to clarify the coder's intent that the variable not be changed (which many consider dubious
			reason for its usage), and dealing with anonymous inner classes." - http://stackoverflow.com/a/266981/1447621