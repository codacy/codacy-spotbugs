# [Field is a mutable collection which should be package protected](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_MUTABLE_COLLECTION_PKGPROTECT)

A mutable collection instance is assigned to a final static field,
   thus can be changed by malicious code or by accident from another package.
   The field could be made package protected to avoid this vulnerability.
   Alternatively you may wrap this field into Collections.unmodifiableSet/List/Map/etc.
   to avoid this vulnerability.