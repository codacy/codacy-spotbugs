# [Mutable object-type field is public](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PA_PUBLIC_MUTABLE_OBJECT_ATTRIBUTE)

    [SEI CERT rule OBJ01-J](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/object-orientation-obj/obj01-j/) requires that accessibility of fields must be limited.
    Making a mutable object-type field final does not prevent other classes from modifying the
    contents of the object. However, in general, requiring that no fields are allowed to be public
    is overkill and unrealistic. There may be usages for public fields: some public fields may
    serve as "flags" that affect the behavior of the class. Such flag fields are expected to be
    read by the current instance (or the current class, in case of static fields), but written by
    others. If a field is both written by the methods of the current instance (or the current
    class, in case of static fields) and from the outside, the code is suspicious. Consider making
    these fields private and provide appropriate setters, if necessary. Please note that
    constructors, initializers and finalizers are exceptions, if only they write the field inside
    the class, the field is not considered as written by the class itself. In case of object-type
    fields "writing" means calling methods whose name suggest modification.

See [CWE-766: Critical Data Element Declared Public](https://cwe.mitre.org/data/definitions/766.html).