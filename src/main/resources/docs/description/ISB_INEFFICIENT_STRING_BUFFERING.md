# [Method passes simple concatenating string in StringBuffer or StringBuilder append](http://fb-contrib.sourceforge.net/bugdescriptions.html#ISB_INEFFICIENT_STRING_BUFFERING)

This method uses `StringBuffer` or `StringBuilder`'s append method to concatenate strings. However, it passes the result
			of doing a simple String concatenation to one of these append calls, thus removing any performance gains
			of using the `StringBuffer` or `StringBuilder` class.

			Java will implicitly use StringBuilders, which can make this hard to detect or fix.  For example,   

    StringBuilder sb = new StringBuilder();
    for (Map.Entry e : map.entrySet()) { sb.append(e.getKey() + e.getValue()); //bug detected here }

			gets automatically turned into something like:   

    StringBuilder sb = new StringBuilder();
    for (Map.Entry e : map.entrySet()) { StringBuilder tempBuilder = new StringBuilder(); tempBuilder.append(e.getKey()); tempBuilder.append(e.getValue()); sb.append(tempBuilder.toString()); //this isn't too efficient }

			which involves a temporary `StringBuilder`, which is completely unnecessary.  To prevent this from happening, simply do:  

    StringBuilder sb = new StringBuilder();
    for (Map.Entry e : map.entrySet()) { sb.append(e.getKey()); sb.append(e.getValue()); }