# [Method annotated with @Transactional is called from a non Spring proxy](http://fb-contrib.sourceforge.net/bugdescriptions.html#JPAI_NON_PROXIED_TRANSACTION_CALL)

This method call is to a method that has a @Transactional annotation on it. However, since this call is from the
    		same class, it is not going through any Spring proxy, and thus the transactional quality of this method is completely
    		lost. @Transactional methods must always be called through a Spring bean that is autowired.