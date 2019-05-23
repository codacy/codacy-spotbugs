# [Method makes literal string comparisons passing the literal as an argument](http://fb-contrib.sourceforge.net/bugdescriptions.html#LSC_LITERAL_STRING_COMPARISON)

This line is in the form of   

    String str = ...
    str.equals("someOtherString");
    //or
    str.compareTo("someOtherString");

A `NullPointerException` may occur if the String variable `str` is `null`. If instead the code was restructured to  

    String str = ...
    "someOtherString".equals(str);
    //or
    "someOtherString".compareTo(str);

			that is, call `equals()` or `compareTo()` on the string literal, passing the
			variable as an argument, then this exception could never happen as both `equals()` and
			`compareTo()` check for `null`.