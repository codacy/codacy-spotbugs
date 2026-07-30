# [Class doesn't override equals in superclass](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EQ_DOESNT_OVERRIDE_EQUALS)

 This class extends a class that defines an equals method and adds fields, but doesn't
  define an equals method itself. Thus, equality on instances of this class will
  ignore the identity of the subclass and the added fields. Be sure this is what is intended,
  and that you don't need to override the equals method.

 Warning: Simply overriding equals in the subclass may break the symmetry contract
  of equals. For example, if the superclass uses `instanceof` in its equals method,
  then `parent.equals(child)` may return `true` but
  `child.equals(parent)` may return `false`.
  Consider whether overriding equals is truly necessary before doing so.