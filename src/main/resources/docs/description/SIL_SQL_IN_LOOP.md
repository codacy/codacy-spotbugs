# [Method executes SQL queries inside of loops](http://fb-contrib.sourceforge.net/bugdescriptions.html#SIL_SQL_IN_LOOP)

This method executes SQL queries inside of a loop. This pattern is often inefficient
			as the number of queries may mushroom in fencepost cases. It is probably more performant
			to loop over the input and collect the key data needed for the query for all items, and
			issue one query using an in clause, or similar construct, and then loop over this result
			set, and fetch all the data at once.