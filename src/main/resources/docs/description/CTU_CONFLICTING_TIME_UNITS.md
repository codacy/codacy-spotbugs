# [This method performs arithmetic operations on time values with different units](http://fb-contrib.sourceforge.net/bugdescriptions.html#CTU_CONFLICTING_TIME_UNITS)

This method takes two values that appear to be representing time, and performs arithmetic operations on these
    		two values directly, even though it appears that the two values are representing different time units, such as
    		adding a millisecond value to a nanosecond value. You should convert the two values to the same time unit before
    		performing this calculation in order for it to be meaningful.