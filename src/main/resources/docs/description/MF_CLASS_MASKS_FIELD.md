# [Class defines field that masks a superclass field](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#MF_CLASS_MASKS_FIELD)

 This class defines a field with the same name as a visible
instance field in a superclass.  This is confusing, and
may indicate an error if methods update or access one of
the fields when they wanted the other.