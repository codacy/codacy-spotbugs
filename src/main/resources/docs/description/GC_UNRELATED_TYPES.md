# [No relationship between generic parameter and method argument](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#GC_UNRELATED_TYPES)

 This call to a generic collection method contains an argument
     with an incompatible class from that of the collection's parameter
    (i.e., the type of the argument is neither a supertype nor a subtype
        of the corresponding generic type argument).
     Therefore, it is unlikely that the collection contains any objects
    that are equal to the method argument used here.
    Most likely, the wrong value is being passed to the method.

In general, instances of two unrelated classes are not equal.
    For example, if the `Foo` and `Bar` classes
    are not related by subtyping, then an instance of `Foo`
        should not be equal to an instance of `Bar`.
    Among other issues, doing so will likely result in an equals method
    that is not symmetrical. For example, if you define the `Foo` class
    so that a `Foo` can be equal to a `String`,
    your equals method isn't symmetrical since a `String` can only be equal
    to a `String`.

In rare cases, people do define nonsymmetrical equals methods and still manage to make
    their code work. Although none of the APIs document or guarantee it, it is typically
    the case that if you check if a `Collection<String>` contains
    a `Foo`, the equals method of argument (e.g., the equals method of the
    `Foo` class) used to perform the equality checks.