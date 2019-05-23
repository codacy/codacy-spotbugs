# [Dead store of class literal](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DLS_DEAD_STORE_OF_CLASS_LITERAL)

This instruction assigns a class literal to a variable and then never uses it.
[The behavior of this differs in Java 1.4 and in Java 5.](http://www.oracle.com/technetwork/java/javase/compatibility-137462.html#literal)
In Java 1.4 and earlier, a reference to `Foo.class` would force the static initializer
for `Foo` to be executed, if it has not been executed already.
In Java 5 and later, it does not.

See Sun's [article on Java SE compatibility](http://www.oracle.com/technetwork/java/javase/compatibility-137462.html#literal)
for more details and examples, and suggestions on how to force class initialization in Java 5.