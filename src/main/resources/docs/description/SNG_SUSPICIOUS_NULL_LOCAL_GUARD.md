# [Method tests a local variable for not null as guard and reassigns it](http://fb-contrib.sourceforge.net/bugdescriptions.html#SNG_SUSPICIOUS_NULL_LOCAL_GUARD)

This method tests a local variable to make sure it's not null before executing a conditional block of
			code. However, in the conditional block it reassigns the local variable. It is likely that the guard
			should have been a check to see if the local variable is null, not that the local variable was not null.

example:

    if (name != null) {
        name = person.getName();
    }

			It is possible this is correct, but it seems likely the guard was meant to be `if (name == null)`