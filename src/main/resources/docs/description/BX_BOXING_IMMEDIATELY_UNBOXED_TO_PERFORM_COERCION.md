# [Primitive value is boxed then unboxed to perform primitive coercion](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BX_BOXING_IMMEDIATELY_UNBOXED_TO_PERFORM_COERCION)

A primitive boxed value constructed and then immediately converted into a different primitive type
(e.g., `new Double(d).intValue()`). Just perform direct primitive coercion (e.g., `(int) d`).