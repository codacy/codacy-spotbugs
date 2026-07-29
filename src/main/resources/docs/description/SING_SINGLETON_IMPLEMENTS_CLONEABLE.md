# [Class using singleton design pattern directly implements Cloneable interface.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_IMPLEMENTS_CLONEABLE)

        If a class using singleton design pattern directly implements the Cloneable interface, it is possible to create a copy of the object, thus violating the singleton pattern.  

        Therefore, implementing the Cloneable interface should be avoided.  

        For more information, see: [SEI CERT MSC07-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/miscellaneous-msc/msc07-j/), and
        [CWE-543: Use of Singleton Pattern Without Synchronization in a Multithreaded Context](https://cwe.mitre.org/data/definitions/543.html).