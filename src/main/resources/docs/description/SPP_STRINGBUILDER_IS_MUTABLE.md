# [Method needlessly assigns a StringBuilder to itself, as it's mutable](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_STRINGBUILDER_IS_MUTABLE)

This method calls StringBuilder.append and assigns the results to the same StringBuilder like:

			`sb = sb.append("foo")`

StringBuilder is mutable, so this is not necessary.
			This is also true of StringBuffer.