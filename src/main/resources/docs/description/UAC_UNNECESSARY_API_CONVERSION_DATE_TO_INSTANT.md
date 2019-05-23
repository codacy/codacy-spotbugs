# [Method constructs a Date object, merely to convert it to an Instant object](http://fb-contrib.sourceforge.net/bugdescriptions.html#UAC_UNNECESSARY_API_CONVERSION_DATE_TO_INSTANT)

This method creates a java.time.Instant object by first creating a java.util.Date object, and then calling
    		toInstant() on it. It is simpler to just construct the Instant object directly, say by using
    		{@code Instant.now()} to get the current time, of by using {@code Instant.parse(CharSequence)} to convert a String.