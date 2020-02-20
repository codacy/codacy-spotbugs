# [equals method overrides equals in superclass and may not be symmetric](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_OVERRIDING_EQUALS_NOT_SYMMETRIC)

 This class defines an equals method that overrides an equals method in a superclass. Both equals methods
use `instanceof` in the determination of whether two objects are equal. This is fraught with peril,
since it is important that the equals method is symmetrical (in other words, `a.equals(b) == b.equals(a)`).
If B is a subtype of A, and A's equals method checks that the argument is an instanceof A, and B's equals method
checks that the argument is an instanceof B, it is quite likely that the equivalence relation defined by these
methods is not symmetric.