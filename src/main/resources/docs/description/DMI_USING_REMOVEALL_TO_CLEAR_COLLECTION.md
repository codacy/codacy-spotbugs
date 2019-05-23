# [Don't use removeAll to clear a collection](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#DMI_USING_REMOVEALL_TO_CLEAR_COLLECTION)

 If you want to remove all elements from a collection `c`, use `c.clear`,
not `c.removeAll(c)`. Calling  `c.removeAll(c)` to clear a collection
is less clear, susceptible to errors from typos, less efficient and
for some collections, might throw a `ConcurrentModificationException`.