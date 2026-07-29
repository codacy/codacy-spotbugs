# [Method hiding should be avoided.](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HSM_HIDING_METHOD)

        Hiding happens when a subclass defines a static method
        with same header (signature plus return type) as in any of the super classes.
        In the event of method hiding the invoked method is determined based on the specific qualified name or
        method invocation expression used at the calling site.
        The results are often unexpected, although the Java language provides unambiguous rules for method invocation for method hiding.
        Moreover, method hiding and method overriding is often confused by programmers.
        Consequently, programmers should avoid the method hiding.
        Programmer should declare the respective method non-static or restrict it as private to eradicate the problem.

        See SEI CERT rule [MET07-J. Never declare a class method that hides a method declared in a superclass or superinterface](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/methods-met/met07-j/).