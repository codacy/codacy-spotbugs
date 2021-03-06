# [Method doesn't override method in superclass due to wrong package for parameter](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NM_WRONG_PACKAGE_INTENTIONAL)

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
        public int f(alpha.Foo x) { return 27; }
    }

The `f(Foo)` method defined in class `B` doesn't
override the
`f(Foo)` method defined in class `A`, because the argument
types are `Foo`'s from different packages.

In this case, the subclass does define a method with a signature identical to the method in the superclass,
so this is presumably understood. However, such methods are exceptionally confusing. You should strongly consider
removing or deprecating the method with the similar but not identical signature.