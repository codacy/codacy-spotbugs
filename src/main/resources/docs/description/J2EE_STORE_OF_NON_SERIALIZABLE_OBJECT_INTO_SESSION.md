# [Store of non serializable object into HttpSession](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#J2EE_STORE_OF_NON_SERIALIZABLE_OBJECT_INTO_SESSION)

This code seems to be storing a non-serializable object into an HttpSession.
If this session is passivated or migrated, an error will result.