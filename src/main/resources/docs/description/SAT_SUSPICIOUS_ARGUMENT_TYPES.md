# [This method invokes a method with parameters that seem incorrect for their intended use](http://fb-contrib.sourceforge.net/bugdescriptions.html#SAT_SUSPICIOUS_ARGUMENT_TYPES)

This method calls a method passing arguments that seem incorrect for the intended purpose of the method. Make sure that the argument types are valid

*   For Match.hasEntry it seems unlikely you want to pass a Matcher and non-Matcher at the same time