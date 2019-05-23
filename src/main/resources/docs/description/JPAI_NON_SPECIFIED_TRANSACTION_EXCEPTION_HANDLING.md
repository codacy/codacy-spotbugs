# [Method does not specify how to handle transaction when exception is thrown](http://fb-contrib.sourceforge.net/bugdescriptions.html#JPAI_NON_SPECIFIED_TRANSACTION_EXCEPTION_HANDLING)

This method declares that it throws one or more non-runtime exceptions. It also is annotated with a
    		@Transactional annotation but fails to describe whether to rollback the transaction or not based on this
    		thrown exception. Use 'rollbackFor' or 'noRollbackFor' attributes of the Transactional annotation to
    		document this.