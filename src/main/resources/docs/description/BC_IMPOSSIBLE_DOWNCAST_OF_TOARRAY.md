# [Impossible downcast of toArray() result](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_IMPOSSIBLE_DOWNCAST_OF_TOARRAY)

This code is casting the result of calling `toArray()` on a collection
to a type more specific than `Object[]`, as in:

    String[] getAsArray(Collection<String> c) {
        return (String[]) c.toArray();
    }

This will usually fail by throwing a ClassCastException. The `toArray()`
of almost all collections return an `Object[]`. They can't really do anything else,
since the Collection object has no reference to the declared generic type of the collection.

The correct way to do get an array of a specific type from a collection is to use
  `c.toArray(new String[]);`
  or `c.toArray(new String[c.size()]);` (the latter is slightly more efficient).

There is one common/known exception to this. The `toArray()`
method of lists returned by `Arrays.asList(...)` will return a covariantly
typed array. For example, `Arrays.asArray(new String[] { "a" }).toArray()`
will return a `String []`. SpotBugs attempts to detect and suppress
such cases, but may miss some.