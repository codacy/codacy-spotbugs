# [Field is a mutable collection](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_MUTABLE_COLLECTION)

A mutable collection instance is assigned to a final static field,
   thus can be changed by malicious code or by accident from another package.
   Consider wrapping this field into Collections.unmodifiableSet/List/Map/etc.
   to avoid this vulnerability.