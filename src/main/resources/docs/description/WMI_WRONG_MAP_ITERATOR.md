# [Inefficient use of keySet iterator instead of entrySet iterator](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#WMI_WRONG_MAP_ITERATOR)

 This method accesses the value of a Map entry, using a key that was retrieved from
a keySet iterator. It is more efficient to use an iterator on the entrySet of the map, to avoid the
Map.get(key) lookup.