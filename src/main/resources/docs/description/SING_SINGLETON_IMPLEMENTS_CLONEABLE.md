# [Class using singleton design pattern directly implements Cloneable interface.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_IMPLEMENTS_CLONEABLE)

        If a class using singleton design pattern directly implements the Cloneable interface, it is possible to create a copy of the object, thus violating the singleton pattern.  

        Therefore, implementing the Cloneable interface should be avoided.  

        For more information, see: [SEI CERT MSC07-J](https://wiki.sei.cmu.edu/confluence/display/java/MSC07-J.+Prevent+multiple+instantiations+of+singleton+objects).