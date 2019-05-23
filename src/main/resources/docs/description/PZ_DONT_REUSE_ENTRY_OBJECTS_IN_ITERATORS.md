# [Don't reuse entry objects in iterators](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#PZ_DONT_REUSE_ENTRY_OBJECTS_IN_ITERATORS)

 The entrySet() method is allowed to return a view of the
     underlying Map in which an Iterator and Map.Entry. This clever
     idea was used in several Map implementations, but introduces the possibility
     of nasty coding mistakes. If a map `m` returns
     such an iterator for an entrySet, then
     `c.addAll(m.entrySet())` will go badly wrong. All of
     the Map implementations in OpenJDK 1.7 have been rewritten to avoid this,
     you should to.