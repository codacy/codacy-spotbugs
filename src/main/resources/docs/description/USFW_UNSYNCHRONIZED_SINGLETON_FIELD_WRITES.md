# [Method of Singleton class writes to a field in an unsynchronized manner](http://fb-contrib.sourceforge.net/bugdescriptions.html#USFW_UNSYNCHRONIZED_SINGLETON_FIELD_WRITES)

This method writes to a field of this class. Since this class is seen as a Singleton this can produce race
    		conditions, or cause non-visible changes to other threads, because the field isn't accessed synchronously.