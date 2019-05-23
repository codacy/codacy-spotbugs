# [Use of class without a hashCode() method in a hashed data structure](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HE_USE_OF_UNHASHABLE_CLASS)

 A class defines an equals(Object)  method but not a hashCode() method,
and thus doesn't fulfill the requirement that equal objects have equal hashCodes.
An instance of this class is used in a hash data structure, making the need to
fix this problem of highest importance.