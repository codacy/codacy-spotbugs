# [Be wary of letting constructors throw exceptions.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#CT_CONSTRUCTOR_THROW)

Classes that throw exceptions in their constructors are vulnerable to Finalizer attacks

A finalizer attack can be prevented, by declaring the class final, using an empty finalizer declared as final, or by a clever use of a private constructor.

See [`SEI CERT Rule OBJ-11`](https://wiki.sei.cmu.edu/confluence/display/java/OBJ11-J.+Be+wary+of+letting+constructors+throw+exceptions)
            for more information.