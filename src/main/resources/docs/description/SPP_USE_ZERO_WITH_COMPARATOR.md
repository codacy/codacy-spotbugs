# [Method compares the result of a compareTo method to a value other than zero](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_USE_ZERO_WITH_COMPARATOR)

			This method calls the compareTo method on an object and then compares the resultant value to a value other than
			zero. The compareTo method is really only specified to return 0, a positive number or a negative number, so you should 
			compare as == 0, or > 0 or < 0, and not to a specific value like == 1.