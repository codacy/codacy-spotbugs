# [Invocation of equals() on an array, which is equivalent to ==](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EC_BAD_ARRAY_COMPARE)

This method invokes the .equals(Object o) method on an array. Since arrays do not override the equals
method of Object, calling equals on an array is the same as comparing their addresses. To compare the
contents of the arrays, use `java.util.Arrays.equals(Object[], Object[])`.
To compare the addresses of the arrays, it would be
less confusing to explicitly check pointer equality using `==`.