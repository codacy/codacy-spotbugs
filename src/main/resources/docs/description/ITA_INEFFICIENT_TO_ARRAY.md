# [Method uses toArray() with zero-length array argument](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#ITA_INEFFICIENT_TO_ARRAY)

 This method uses the toArray() method of a collection derived class, and passes
in a zero-length prototype array argument.  It is more efficient to use
`myCollection.toArray(new Foo[myCollection.size()])`
If the array passed in is big enough to store all of the
elements of the collection, then it is populated and returned
directly. This avoids the need to create a second array
(by reflection) to return as the result.