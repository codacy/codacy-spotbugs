# [Method has a Spring @Transactional annotation on it, but is non-public](http://fb-contrib.sourceforge.net/bugdescriptions.html#JPAI_TRANSACTION_ON_NON_PUBLIC_METHOD)

This method specifies a Spring @Transactional annotation but the method is defined as being non-public.
    		Spring only creates transactional boundaries on methods that are public, and so this annotation is not doing
    		anything for this method. Make the method public, or place the annotation on a more appropriate method.