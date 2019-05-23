# [Field is a mutable array](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_MUTABLE_ARRAY)

 A final static field references an array
   and can be accessed by malicious code or
        by accident from another package.
   This code can freely modify the contents of the array.