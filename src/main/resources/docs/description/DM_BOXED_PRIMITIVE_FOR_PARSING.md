# [Boxing/unboxing to parse a primitive](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DM_BOXED_PRIMITIVE_FOR_PARSING)

A boxed primitive is created from a String, just to extract the unboxed primitive value.
  It is more efficient to just call the static parseXXX method.