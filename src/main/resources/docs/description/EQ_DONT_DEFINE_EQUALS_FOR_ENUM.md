# [Covariant equals() method defined for enum](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_DONT_DEFINE_EQUALS_FOR_ENUM)

 This class defines an enumeration, and equality on enumerations are defined
using object identity. Defining a covariant equals method for an enumeration
value is exceptionally bad practice, since it would likely result
in having two different enumeration values that compare as equals using
the covariant enum method, and as not equal when compared normally.
Don't do it.