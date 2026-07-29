# [Instance-getter method of class using singleton design pattern is not synchronized.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_GETTER_NOT_SYNCHRONIZED)

        Instance-getter method of class using singleton design pattern is not synchronized. When this method is invoked by two or more threads simultaneously,
        multiple instantiation of a singleton class becomes possible.  

        For more information, see: [SEI CERT MSC07-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/miscellaneous-msc/msc07-j/), and
        [CWE-543: Use of Singleton Pattern Without Synchronization in a Multithreaded Context](https://cwe.mitre.org/data/definitions/543.html).