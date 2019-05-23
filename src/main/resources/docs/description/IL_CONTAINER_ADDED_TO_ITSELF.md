# [A collection is added to itself](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#IL_CONTAINER_ADDED_TO_ITSELF)

A collection is added to itself. As a result, computing the hashCode of this
set will throw a StackOverflowException.