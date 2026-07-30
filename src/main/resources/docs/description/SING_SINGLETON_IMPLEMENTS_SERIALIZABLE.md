# [Class using singleton design pattern directly or indirectly implements Serializable interface.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_IMPLEMENTS_SERIALIZABLE)

        This class (using singleton design pattern) directly or indirectly implements the Serializable interface, which allows the class to be serialized.  

        Deserialization makes multiple instantiation of a singleton class possible, and therefore should be avoided.  

        For more information, see: [SEI CERT MSC07-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/miscellaneous-msc/msc07-j/), and
        [CWE-543: Use of Singleton Pattern Without Synchronization in a Multithreaded Context](https://cwe.mitre.org/data/definitions/543.html).