# [Primitive value is unboxed and coerced for ternary operator](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BX_UNBOXED_AND_COERCED_FOR_TERNARY_OPERATOR)

A wrapped primitive value is unboxed and converted to another primitive type as part of the
evaluation of a conditional ternary operator (the ` b ? e1 : e2` operator). The
semantics of Java mandate that if `e1` and `e2` are wrapped
numeric values, the values are unboxed and converted/coerced to their common type (e.g,
if `e1` is of type `Integer`
and `e2` is of type `Float`, then `e1` is unboxed,
converted to a floating point value, and boxed. See JLS Section 15.25.