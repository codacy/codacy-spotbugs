# [Class using singleton design pattern directly or indirectly implements Serializable interface.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_IMPLEMENTS_SERIALIZABLE)

        This class (using singleton design pattern) directly or indirectly implements the Serializable interface, which allows the class to be serialized.  

        Deserialization makes multiple instantiation of a singleton class possible, and therefore should be avoided.  

        [SEI CERT MSC07-J](https://wiki.sei.cmu.edu/confluence/display/java/MSC07-J.+Prevent+multiple+instantiations+of+singleton+objects) rule