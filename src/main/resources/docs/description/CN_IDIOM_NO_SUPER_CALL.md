# [clone method does not call super.clone()](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CN_IDIOM_NO_SUPER_CALL)

 This non-final class defines a clone() method that does not call super.clone().
If this class ("_A_") is extended by a subclass ("_B_"),
and the subclass _B_ calls super.clone(), then it is likely that
_B_'s clone() method will return an object of type _A_,
which violates the standard contract for clone().

 If all clone() methods call super.clone(), then they are guaranteed
to use Object.clone(), which always returns an object of the correct type.