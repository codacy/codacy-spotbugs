# [Method uses delayed execution of a block of code that is trivial](http://fb-contrib.sourceforge.net/bugdescriptions.html#OI_OPTIONAL_ISSUES_USES_DELAYED_EXECUTION)

This method uses the Optional.orElseGet() method passing in a simple variable or constant value.
    		As this value takes no time to execute and causes no side effects, the use of Optional.orElseGet is
    		unnecessary and potentially confusing. You can use Optional.orElse() instead.