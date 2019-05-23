# [Method does not presize the allocation of a collection](http://fb-contrib.sourceforge.net/bugdescriptions.html#PSC_PRESIZE_COLLECTIONS)

This method allocates a collection using the default constructor even though it is known
			a priori (or at least can be reasonably guessed) how many items are going to be placed in the collection,
			and thus needlessly causes intermediate reallocations of the collection.

You can use the constructor that takes an initial size and that will be much better, but
			due to the loadFactor of Maps and Sets, even this will not be a correct estimate.

If you are using Guava, use its methods that allocate maps and sets with a predetermined size,
			to get the best chance for no reallocations, such as:

*   Sets.newHashSetWithExpectedSize(int)
*   Maps.newHashMapWithExpectedSize(int)

			If not, a good estimate would be the expectedSize / {LOADING_FACTOR} which by default is 0.75