# [Method calls String.format on a static (non parameterized) format string](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_STATIC_FORMAT_STRING)

This method calls String.format, passing a static string that has no replacement markers (starting with %)
			as the format string. Thus no replacement will happen, and the format method is superfluous. If parameters were intended,
			add the appropriate format markers as needed; otherwise, just remove the call to String.format and use the static
			string as is.