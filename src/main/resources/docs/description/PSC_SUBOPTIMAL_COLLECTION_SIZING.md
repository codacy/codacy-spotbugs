# [Method uses suboptimal sizing to allocate a collection](http://fb-contrib.sourceforge.net/bugdescriptions.html#PSC_SUBOPTIMAL_COLLECTION_SIZING)

This method allocates a collection using the a constructor that takes a size parameter. However,
			because Maps and Sets have a loading factor, passing in the exact size you want is an
			incorrect way to presize the collection, and may still cause reallocations. Since you are using
			Guava, it is better to use

    Maps.newHashMapWithExpectedSize(c.size());

			or
			`

<pre>
				Sets.newHashSetWithExpectedsize(c.size());
			</pre>

`
			as this method calculates the correct size taking into account the loading factor.

			Alternatively, if you know that the collection will not grow beyond the initial size,
			you can specify a load factor of 1.0F in the constructor.