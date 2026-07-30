# [Class using singleton design pattern has non-private constructor.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_HAS_NONPRIVATE_CONSTRUCTOR)

        This class is using singleton design pattern and has non-private constructor (please note that a default constructor might exist which is not private). Given that, it is possible to create a copy of the object, thus violating the singleton pattern.  

        The easier solution would be making the constructor private.  

        For more information, see: [SEI CERT MSC07-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/miscellaneous-msc/msc07-j/), and
        [CWE-543: Use of Singleton Pattern Without Synchronization in a Multithreaded Context](https://cwe.mitre.org/data/definitions/543.html).