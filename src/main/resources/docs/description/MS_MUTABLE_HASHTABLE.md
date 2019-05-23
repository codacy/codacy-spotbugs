# [Field is a mutable Hashtable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_MUTABLE_HASHTABLE)

A final static field references a Hashtable
   and can be accessed by malicious code or
        by accident from another package.
   This code can freely modify the contents of the Hashtable.