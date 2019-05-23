# [Equals method should not assume anything about the type of its argument](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS)

The `equals(Object o)` method shouldn't make any assumptions
about the type of `o`. It should simply return
false if `o` is not the same type as `this`.