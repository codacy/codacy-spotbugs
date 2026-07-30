# [Class using singleton design pattern implements clone() method without being an unconditional CloneNotSupportedException-thrower.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SING_SINGLETON_IMPLEMENTS_CLONE_METHOD)

        This class is using singleton design pattern and does not implement the Cloneable interface, but implements the clone() method without being an unconditional CloneNotSupportedException-thrower.
        With that, it is possible to create a copy of the object, thus violating the singleton pattern.  

        Therefore, implementing the clone method should be avoided, otherwise the solution would be overriding the clone method to unconditionally throw CloneNotSupportedException.  

        For more information, see: [SEI CERT MSC07-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/miscellaneous-msc/msc07-j/), and
        [CWE-543: Use of Singleton Pattern Without Synchronization in a Multithreaded Context](https://cwe.mitre.org/data/definitions/543.html).