# [Method ignores the return value of EntityManager.merge](http://fb-contrib.sourceforge.net/bugdescriptions.html#JPAI_IGNORED_MERGE_RESULT)

This method calls EntityManager.merge, and throws away the resultant value. This result is the
    		managed entity version of the potentially unmanaged object that was passed to merge. You should use
    		the returned managed entity for any further use.