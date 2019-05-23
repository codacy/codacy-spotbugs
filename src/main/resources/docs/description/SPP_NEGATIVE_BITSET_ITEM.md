# [Method passes a negative number as a bit to a BitSet which isn't supported](http://fb-contrib.sourceforge.net/bugdescriptions.html#SPP_NEGATIVE_BITSET_ITEM)

This method passes a constant negative value as a bit position to a java.util.BitSet. The BitSet class
			doesn't support negative values, and thus this method call will not work as expected.