# [This method parses a String that is a field](http://fb-contrib.sourceforge.net/bugdescriptions.html#STT_STRING_PARSING_A_FIELD)

This method calls a parsing method (indexOf, lastIndexOf, startsWith, endsWith, substring, indexOf) on a String
            that is a field, or comes from a collection that is a field. This implies that the String in question is holding
            multiple parts of information inside the string, which would be more maintainable and type safe if that value was a
            true collection or a first class object with fields, rather than a String.