# [equals(...) used to compare incompatible arrays](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#EC_INCOMPATIBLE_ARRAY_COMPARE)

This method invokes the .equals(Object o) to compare two arrays, but the arrays
of incompatible types (e.g., String[] and StringBuffer[], or String[] and int[]).
They will never be equal. In addition, when equals(...) is used to compare arrays it
only checks to see if they are the same array, and ignores the contents of the arrays.