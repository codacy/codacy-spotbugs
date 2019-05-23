# [Class implements same interface as superclass](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#RI_REDUNDANT_INTERFACES)

    This class declares that it implements an interface that is also implemented by a superclass.
    This is redundant because once a superclass implements an interface, all subclasses by default also
    implement this interface. It may point out that the inheritance hierarchy has changed since
    this class was created, and consideration should be given to the ownership of
    the interface's implementation.