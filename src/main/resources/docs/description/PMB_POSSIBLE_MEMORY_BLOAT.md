# [Potential memory bloat in static field](http://fb-contrib.sourceforge.net/bugdescriptions.html#PMB_POSSIBLE_MEMORY_BLOAT)

This class defines static fields that are `Collection`s, `StringBuffer`s, or `StringBuilder`s
			that do not appear to have any way to clear or reduce their size. That is, a collection is defined
			and has method calls like   

			{`add()`, `append()`, `offer()`, `put()`, ...}   

			with no method calls to removal methods like  

			{`clear()`, `delete()`, `pop()`, `remove()`, ...}  

			This means that the collection in question can only ever increase in size, which is
			a potential cause of memory bloat.

			If this collection is a list, set or otherwise of static things (e.g. a List>String> for month names), consider
			adding all of the elements in a static initializer, which can only be called once:  

    private static List<String> monthNames = new ArrayList<String>();
    static {
        monthNames.add("January");
        monthNames.add("February");
        monthNames.add("March");
        ...
    }