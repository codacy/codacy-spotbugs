# [Method needlessly boxes a boolean constant](http://fb-contrib.sourceforge.net/bugdescriptions.html#NAB_NEEDLESS_BOOLEAN_CONSTANT_CONVERSION)

This method assigns a Boxed boolean constant to a primitive boolean variable, or assigns a primitive boolean
			constant to a Boxed boolean variable. Use the correct constant for the variable desired. Use   

    boolean b = true;
    boolean b = false;

			or   

    Boolean b = Boolean.TRUE;
    Boolean b = Boolean.FALSE;

Be aware that this boxing happens automatically when you might not expect it.  For example,   

    Map statusMap = ... public Boolean someMethod() { statusMap.put("foo", true); //the "true" here is boxed return false; //the "false" here is boxed }

			has two cases of this needless autoboxing.  This can be made more efficient by simply substituting
			in the constant values:   

    Map statusMap = ... public Boolean someMethod() { statusMap.put("foo", Boolean.TRUE); return Boolean.FALSE; }