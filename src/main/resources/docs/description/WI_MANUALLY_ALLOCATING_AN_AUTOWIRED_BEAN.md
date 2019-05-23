# [Method allocates an object with new when the class is defined as an autowireable bean](http://fb-contrib.sourceforge.net/bugdescriptions.html#WI_MANUALLY_ALLOCATING_AN_AUTOWIRED_BEAN)

This method allocates an object with new, but the class of the object that is being created is marked with a Spring annotation
    		denoting that this class is to be used through an @Autowire annotation. Allocating it with `new` will likely mean that fields on the
    		class will not be autowired, but instead be null. You should just autowire an instance of this class into the class in question, or if
    		need be, use Spring's getBean(name) method to fetch one.