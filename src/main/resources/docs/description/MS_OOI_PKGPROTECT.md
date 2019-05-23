# [Field should be moved out of an interface and made package protected](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MS_OOI_PKGPROTECT)

 A final static field that is
defined in an interface references a mutable
   object such as an array or hashtable.
   This mutable object could
   be changed by malicious code or
        by accident from another package.
   To solve this, the field needs to be moved to a class
   and made package protected
   to avoid
        this vulnerability.