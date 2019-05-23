# [Questionable cast to concrete collection](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_BAD_CAST_TO_CONCRETE_COLLECTION)

This code casts an abstract collection (such as a Collection, List, or Set)
to a specific concrete implementation (such as an ArrayList or HashSet).
This might not be correct, and it may make your code fragile, since
it makes it harder to switch to other concrete implementations at a future
point. Unless you have a particular reason to do so, just use the abstract
collection class.