# [Huge string constants is duplicated across multiple class files](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#HSC_HUGE_SHARED_STRING_CONSTANT)

    A large String constant is duplicated across multiple class files.
    This is likely because a final field is initialized to a String constant, and the Java language
    mandates that all references to a final field from other classes be inlined into
that classfile. See [JDK bug 6447475](http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6447475)
    for a description of an occurrence of this bug in the JDK and how resolving it reduced
    the size of the JDK by 1 megabyte.