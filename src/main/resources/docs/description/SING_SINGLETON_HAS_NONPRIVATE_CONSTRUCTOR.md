# [Class using singleton design pattern has non-private constructor.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_HAS_NONPRIVATE_CONSTRUCTOR)

        This class is using singleton design pattern and has non-private constructor (please note that a default constructor might exist which is not private). Given that, it is possible to create a copy of the object, thus violating the singleton pattern.  

        The easier solution would be making the constructor private.  

        [SEI CERT MSC07-J](https://wiki.sei.cmu.edu/confluence/display/java/MSC07-J.+Prevent+multiple+instantiations+of+singleton+objects) rule