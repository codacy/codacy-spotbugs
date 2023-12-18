# [Potentially ambiguous invocation of either an inherited or outer method](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IA_AMBIGUOUS_INVOCATION_OF_INHERITED_OR_OUTER_METHOD)

An inner class is invoking a method that could be resolved to either an inherited method or a method defined in an outer class.
For example, you invoke `foo(17)`, which is defined in both a superclass and in an outer method.
By the Java semantics,
it will be resolved to invoke the inherited method, but this may not be what
you intend.

If you really intend to invoke the inherited method,
invoke it by invoking the method on super (e.g., invoke super.foo(17)), and
thus it will be clear to other readers of your code and to SpotBugs
that you want to invoke the inherited method, not the method in the outer class.

If you call `this.foo(17)`, then the inherited method will be invoked. However, since SpotBugs only looks at
classfiles, it
cannot tell the difference between an invocation of `this.foo(17)` and `foo(17)`, it will still
complain about a potential ambiguous invocation.