# [Be wary of letting constructors throw exceptions.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CT_CONSTRUCTOR_THROW)

Classes that throw exceptions in their constructors are vulnerable to Finalizer attacks

A finalizer attack can be prevented, by declaring the class final, using an empty finalizer declared as final, or by a clever use of a private constructor.

See [`SEI CERT Rule OBJ-11`](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/object-orientation-obj/obj11-j/)
            for more information.