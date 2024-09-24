# [Instance-getter method of class using singleton design pattern is not synchronized.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_GETTER_NOT_SYNCHRONIZED)

        Instance-getter method of class using singleton design pattern is not synchronized. When this method is invoked by two or more threads simultaneously, 
        multiple instantiation of a singleton class becomes possible.  

        [SEI CERT MSC07-J](https://wiki.sei.cmu.edu/confluence/display/java/MSC07-J.+Prevent+multiple+instantiations+of+singleton+objects) rule