# [Class using singleton design pattern indirectly implements Cloneable interface.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_INDIRECTLY_IMPLEMENTS_CLONEABLE)

        If a class using singleton design pattern indirectly implements the Cloneable interface, it is possible to create a copy of the object, thus violating the singleton pattern.  

        Therefore, implementing the Cloneable interface should be avoided. If that's not possible because of an extended super-class, the solution would be overriding the clone method to unconditionally throw CloneNotSupportedException.  

        For more information, see: [SEI CERT MSC07-J](https://wiki.sei.cmu.edu/confluence/display/java/MSC07-J.+Prevent+multiple+instantiations+of+singleton+objects).