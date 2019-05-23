# [Method performs a contravariant array assignment](http://fb-contrib.sourceforge.net/bugdescriptions.html#CVAA_CONTRAVARIANT_ARRAY_ASSIGNMENT)

This method contains a contravariant array assignment. Since arrays are mutable data structures, their use
			must be restricted to covariant or invariant usage.

    class A {}
    class B extends A {}

    B[] b = new B[2];
    A[] a = b;