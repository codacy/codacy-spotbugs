# [Method possibly mixes up normal strings and empty strings in branching logic](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_SUSPECT_STRING_TEST)

This method tests a string, and groups null values with real strings, leaving empty strings as another
			case. That is, FindBugs has detected a structure like:   

    String a = null, b = "", c = "someString";

    String testStr = ...;  //one of a, b or c
    if ({{FLAWED_TEST_LOGIC}}) {
        // Strings a and c fall into this branch... which is not typical.
    } else {
        // String b falls into this branch.
    }

			This might be perfectly valid, but normally, null strings and empty strings are logically handled the same way,
			and so this test may be flawed.

Pattern found is one of the following:

*   `if ((s == null) || (s.length() > 0))` --- did you mean
    				`((s == null) || (s.length() == 0))`?
*   `if ((s == null) || (s.length() != 0))` -- did you mean
    				`((s == null) || (s.length() == 0))`?
*   `if ((s != null) && (s.length() == 0))` -- did you mean
    				`((s != null) && (s.length() > 0))` or perhaps
    				`((s == null) || (s.length() == 0))`?