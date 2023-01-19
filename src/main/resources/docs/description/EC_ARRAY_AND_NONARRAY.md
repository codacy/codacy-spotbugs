# [equals() used to compare array and nonarray](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EC_ARRAY_AND_NONARRAY)

This method invokes the .equals(Object o) to compare an array and a reference that doesn't seem
to be an array. If things being compared are of different types, they are guaranteed to be unequal
and the comparison is almost certainly an error. Even if they are both arrays, the `equals()` method
on arrays only determines if the two arrays are the same object.
To compare the contents of the arrays, use `java.util.Arrays.equals(Object[], Object[])`.