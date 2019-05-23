# [Class defines non private logger using a static class context](http://fb-contrib.sourceforge.net/bugdescriptions.html#LO_NON_PRIVATE_STATIC_LOGGER)

This class defines a static logger as non private. It does so by passing the name of a
				class such as

    public static final Logger LOG = LoggerFactory.getLogger(Foo.class);

				Since this class is public it may be used in other classes, but doing so will provide the incorrect
				class reference as the class is hard coded.

				It is recommend to define static loggers as private, and just redefine a new logger in any class
				that you need to have logging done.

If you wish to have a base class define the logger, and have derived classes use that logger, you can
				potentially use instance based logging, such as

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

				However this has the downside of being an instance based logger, and creating a logger object in each instance
				of the class where it is used.