# [Method does not pass an object to commons-lang's ToStringBuilder](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_WRONG_COMMONS_TO_STRING_OBJECT)

			This method uses commons-lang, or commons-lang3's ToStringBuilder to attempt to output a representation of an object.
			However, no object was passed, just the style specifier, and so the output will be of the ToStringStyle object itself.
			Don't forget to include the object you wish to output as the first parameter, such as

<pre>
			ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
			</pre>