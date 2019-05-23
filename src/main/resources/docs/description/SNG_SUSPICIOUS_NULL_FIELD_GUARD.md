# [Method tests a field for not null as guard and reassigns it](http://fb-contrib.sourceforge.net/bugdescriptions.html#SNG_SUSPICIOUS_NULL_FIELD_GUARD)

This method tests a field to make sure it's not null before executing a conditional block of
			code. However, in the conditional block it reassigns the field. It is likely that the guard
			should have been a check to see if the field is null, not that the field was not null.

example:

    if (name != null) {
        name = person.getName();
    }

			It is possible this is correct, but it seems likely the guard was meant to be `if (name == null)`