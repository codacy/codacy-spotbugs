# [Method builds String array using String Tokenizing](http://fb-contrib.sourceforge.net/bugdescriptions.html#USS_USE_STRING_SPLIT)

This method uses a StringTokenizer to split up a String and then walks through the
			separated elements and builds an array from these enumerated values. It is simpler
			and easier to use the String.split method.

PLEASE NOTE: String.split will return an array of 1 element when passed the
			empty string, as opposed to using StringTokenizer which returns false on the first
			hasMoreElements/hasMoreTokens call. So you may need to use:

    if (s.length() > 0) 
        return s.split(";"); 
    return new String[0];