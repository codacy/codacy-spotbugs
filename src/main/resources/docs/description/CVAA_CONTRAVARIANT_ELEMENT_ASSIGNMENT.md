# [Method performs a contravariant array element assignment](http://fb-contrib.sourceforge.net/bugdescriptions.html#CVAA_CONTRAVARIANT_ELEMENT_ASSIGNMENT)

This method contains a contravariant array element assignment. Since arrays are mutable
			data structures, their use must be restricted to covariant or invariant usage.

    class A {}
    class B extends A {}

    B[] b = new B[2];
    A[] a = b;
    a[0] = new A(); // results in ArrayStoreException (Runtime)