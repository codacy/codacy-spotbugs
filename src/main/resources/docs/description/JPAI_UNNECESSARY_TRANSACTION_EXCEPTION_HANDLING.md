# [Method declares handling a transactional exception that won't be thrown](http://fb-contrib.sourceforge.net/bugdescriptions.html#JPAI_UNNECESSARY_TRANSACTION_EXCEPTION_HANDLING)

This method declares that it either rolls back or does not rollback a transaction based on an
    		expected exception being thrown. However, neither this exception, nor any derived exceptions can be thrown
    		from this method, and so the annotation is useless.