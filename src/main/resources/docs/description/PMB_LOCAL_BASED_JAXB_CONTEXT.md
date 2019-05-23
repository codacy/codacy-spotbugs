# [Local JAXBContext created on demand](http://fb-contrib.sourceforge.net/bugdescriptions.html#PMB_LOCAL_BASED_JAXB_CONTEXT)

This method creates a JAXBContext and stores it in a local variable. This
	       implies that this JAXBContext is created each time on demand, which will cause 
	       memory bloat issues. It is better to either create this instance as a static field,
	       or hold onto it with a ConcurrentHashMap, or such. See 
	       https://javaee.github.io/jaxb-v2/doc/user-guide/ch03.html#other-miscellaneous-topics-performance-and-thread-safety