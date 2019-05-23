# [Method uses immediate execution of a block of code that is often not used](http://fb-contrib.sourceforge.net/bugdescriptions.html#OI_OPTIONAL_ISSUES_USES_IMMEDIATE_EXECUTION)

This method uses the Optional.orElse() method passing in some code that will execute immediately, whether
    		or not the else case of the Optional is needed. This may cause incorrect side effects to happen, or at the
    		minimum, code to execute for no reason. It would be better to use Optional.orElseGet()