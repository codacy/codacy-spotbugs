# [Comparator doesn't implement Serializable](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#SE_COMPARATOR_SHOULD_BE_SERIALIZABLE)

 This class implements the `Comparator` interface. You
should consider whether or not it should also implement the `Serializable`
interface. If a comparator is used to construct an ordered collection
such as a `TreeMap`, then the `TreeMap`
will be serializable only if the comparator is also serializable.
As most comparators have little or no state, making them serializable
is generally easy and good defensive programming.