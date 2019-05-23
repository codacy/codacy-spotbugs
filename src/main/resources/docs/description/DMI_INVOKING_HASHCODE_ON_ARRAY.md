# [Invocation of hashCode on an array](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_INVOKING_HASHCODE_ON_ARRAY)

The code invokes hashCode on an array. Calling hashCode on
an array returns the same value as System.identityHashCode, and ignores
the contents and length of the array. If you need a hashCode that
depends on the contents of an array `a`,
use `java.util.Arrays.hashCode(a)`.