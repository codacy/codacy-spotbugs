# [This method uses an excessively complex conditional that can be replaced with Set.contains](http://fb-contrib.sourceforge.net/bugdescriptions.html#CBC_CONTAINS_BASED_CONDITIONAL)

This method uses an overly complex `if` expression made up of multiple conditions joined by OR, where the same
    		local variable is compared to a static value. When the number of conditions grows, it is much cleaner
    		to build a static set of the possible values, and use the contains method on that set. This will
    		shorten the code, and make it more self documenting.