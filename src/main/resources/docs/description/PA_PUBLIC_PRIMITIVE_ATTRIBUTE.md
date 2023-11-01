# [Primitive field is public](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PA_PUBLIC_PRIMITIVE_ATTRIBUTE)

    [SEI CERT rule OBJ01-J](https://wiki.sei.cmu.edu/confluence/display/java/OBJ01-J.+Limit+accessibility+of+fields) requires that accessibility to fields must be limited.
    Otherwise, the values of the fields may be manipulated from outside the class, which may be unexpected or
    undesired behaviour.
    In general, requiring that no fields are allowed to be public is overkill and unrealistic. Even
    the rule mentions that final fields may be public. Besides final fields, there may be other
    usages for public fields: some public fields may serve as "flags" that affect the behavior of
    the class. Such flag fields are expected to be read by the current instance (or the current
    class, in case of static fields), but written by others. If a field is both written by the
    methods of the current instance (or the current class, in case of static fields) and from the
    outside, the code is suspicious. Consider making these fields private and provide appropriate
    setters, if necessary. Please note that constructors, initializers and finalizers are
    exceptions, if only they write the field inside the class, the field is not considered as
    written by the class itself.