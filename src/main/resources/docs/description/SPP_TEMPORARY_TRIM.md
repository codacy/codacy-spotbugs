# [Method trims a String temporarily](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_TEMPORARY_TRIM)

This method calls trim() on a String without assigning the new string to another variable.
			It then calls length() or equals() on this trimmed string. If trimming the string was important
			for determining its length or its equality, it probably should be trimmed when you actually use it.
			It would make more sense to first trim the String, store the trimmed value in a variable, and then
			continue to test and use that trimmed string.