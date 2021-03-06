# [Method doesn't override method in superclass due to wrong package for parameter](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_WRONG_PACKAGE)

 The method in the subclass doesn't override a similar method in a superclass because the type of a parameter doesn't exactly match
the type of the corresponding parameter in the superclass. For example, if you have:

    import alpha.Foo;

    public class A {
        public int f(Foo x) { return 17; }
    }
    ----
    import beta.Foo;

    public class B extends A {
        public int f(Foo x) { return 42; }
    }

The `f(Foo)` method defined in class `B` doesn't
override the
`f(Foo)` method defined in class `A`, because the argument
types are `Foo`'s from different packages.