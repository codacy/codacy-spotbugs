# [Questionable cast to abstract collection](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#BC_BAD_CAST_TO_ABSTRACT_COLLECTION)

This code casts a Collection to an abstract collection
(such as `List`, `Set`, or `Map`).
Ensure that you are guaranteed that the object is of the type
you are casting to. If all you need is to be able
to iterate through a collection, you don't need to cast it to a Set or List.