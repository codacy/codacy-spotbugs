# [Method uses Optional.orElseGet(null)](http://fb-contrib.sourceforge.net/bugdescriptions.html#OI_OPTIONAL_ISSUES_USES_ORELSEGET_WITH_NULL)

This method uses Optional.orElseGet(null). This method is supposed to to receive a lambda expression for what to execute
    		when the Optional is not there. If you want to just return null, use Optional.orElse(null) instead.